package giveangel.back.domain.member.service;

import giveangel.back.domain.member.dto.LoginResponse;
import giveangel.back.domain.member.dto.MemberInfo;
import giveangel.back.domain.member.dto.Tokens;
import giveangel.back.domain.member.entity.Member;
import giveangel.back.domain.member.repository.MemberRepository;
import giveangel.back.global.jwt.JwtTokenProvider;
import giveangel.back.global.jwt.RefreshTokenRepository;
import giveangel.back.global.oauth.component.OAuthCodeUrlProvider;
import giveangel.back.global.oauth.component.OAuthMemberClient;
import giveangel.back.global.oauth.vendor.enums.OAuthServerType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

		/*
		Todo : 토큰반환으로 변경
		 */

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

}
