package giveangel.back.domain.member.service;

import giveangel.back.domain.member.dto.LoginResponse;
import giveangel.back.domain.member.dto.MemberInfo;
import giveangel.back.domain.member.dto.Tokens;
import giveangel.back.domain.member.entity.Member;
import giveangel.back.domain.member.repository.MemberRepository;
import giveangel.back.global.jwt.JwtTokenProvider;
import giveangel.back.global.jwt.RefreshTokenRepository;
import giveangel.back.global.jwt.exception.JwtErrorCode;
import giveangel.back.global.jwt.exception.JwtException;
import giveangel.back.global.oauth.component.OAuthCodeUrlProvider;
import giveangel.back.global.oauth.component.OAuthMemberClient;
import giveangel.back.global.oauth.vendor.enums.OAuthServerType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.DispatcherServlet;

@Transactional
@RequiredArgsConstructor
@Service
public class OAuthService {

	private final OAuthCodeUrlProvider oAuthCodeUrlProvider;
	private final OAuthMemberClient oAuthMemberClient;
	private final MemberRepository memberRepository;
	private final JwtTokenProvider jwtTokenProvider;
	private final RefreshTokenRepository refreshTokenRepository;

	public String provideAuthCodeRequestUrl(OAuthServerType oAuthServerType) {
		return oAuthCodeUrlProvider.provide(oAuthServerType);
	}

	public LoginResponse login(OAuthServerType oAuthServerType, String authCode) {
		Member oauthMember = oAuthMemberClient.fetch(oAuthServerType, authCode);

		Member member = memberRepository.findByoAuthId(oauthMember.getOAuthId())
			.orElseGet(() -> memberRepository.save(oauthMember));

		String accessToken = jwtTokenProvider.issueAccessToken(member);
		String refreshToken = jwtTokenProvider.issueRefreshToken();

		refreshTokenRepository.save(refreshToken, accessToken);

		return LoginResponse.builder()
			.tokens(Tokens.builder()
				.accessToken(accessToken)
				.refreshToken(refreshToken)
				.build())
			.memberInfo(MemberInfo.builder()
				.id(member.getId())
				.email(member.getEmail())
				.profileImg(member.getProfileImageUrl())
				.nickname(member.getNickname())
				.build())
			.build();
	}

	public Tokens refreshToken(Tokens tokens) {
		System.out.println(tokens.refreshToken() + " 가져온 토큰");
		String accessToken = refreshTokenRepository.find(tokens.refreshToken())
			.orElseThrow(() -> new JwtException(JwtErrorCode.INVALID_TOKEN));

		System.out.println(accessToken);

		if (!accessToken.equals(tokens.accessToken())) {
			throw new JwtException(JwtErrorCode.INVALID_TOKEN);
		}

		Member member = jwtTokenProvider.parseAccessTokenByBase64(accessToken);

		String newAccessToken = jwtTokenProvider.issueAccessToken(member);
		String newRefreshToken = jwtTokenProvider.issueRefreshToken();

		refreshTokenRepository.delete(tokens.refreshToken());
		refreshTokenRepository.save(newRefreshToken,newAccessToken);


		return Tokens.builder()
			.accessToken(newAccessToken)
			.refreshToken(newRefreshToken)
			.build();
	}

}
