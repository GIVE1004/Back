package giveangel.back.global.jwt;

import giveangel.back.domain.member.dto.Tokens;
import giveangel.back.domain.member.entity.Member;
import giveangel.back.domain.member.entity.MemberRole;
import giveangel.back.domain.member.entity.OAuthId;
import giveangel.back.global.oauth.vendor.enums.OAuthServerType;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberTokenManager {

	private final JwtProps props;

	private static final String CLAIM_EMAIL = "email";
	private static final String CLAIM_VENDOR = "vendor";
	private static final String CLAIM_NICKNAME = "nickname";
	private static final String CLAIM_ROLE = "role";
	private static final String CLAIM_PROFILE_IMG = "profileImg";

	// 회원 정보로 액세스 토큰 발급
	public String issueAccessToken(Member member) {

		Date now = new Date();

		String token = Jwts.builder()
			.id(String.valueOf(member.getId()))
			.claim(CLAIM_EMAIL, member.getOAuthId().getOauthServerId())
			.claim(CLAIM_VENDOR, member.getOAuthId().getOauthServerType())
			.claim(CLAIM_PROFILE_IMG, member.getOAuthId().getOauthServerType())
			.claim(CLAIM_NICKNAME, member.getNickname())
			.claim(CLAIM_ROLE, member.getRole())
			.issuedAt(now)
			.expiration(new Date(now.getTime() + props.accessExpiration().toMillis()))
			.signWith(Keys.hmacShaKeyFor(props.accessKey().getBytes()))
			.compact();

		return token;
	}

	// 토큰을 회원 정보로 파싱
	public Member parseAccessToken(String token) {
		Claims payload = Jwts.parser()
			.verifyWith(Keys.hmacShaKeyFor(props.accessKey().getBytes()))
			.build()
			.parseSignedClaims(token).getPayload();

		return Member.builder()
			.id(Long.valueOf(payload.getId()))
			.nickname(payload.get(CLAIM_NICKNAME, String.class))
			.profileImageUrl(payload.get(CLAIM_PROFILE_IMG, String.class))
			.role(payload.get(CLAIM_ROLE, MemberRole.class))
			.oAuthId(new OAuthId(
				payload.get(CLAIM_EMAIL, String.class),
				payload.get(CLAIM_VENDOR, OAuthServerType.class)))
			.build();
	}

	// 리프레시 토큰의 경우, Redis에 저장 (key : refresh token 값 , value : Member 정보)



}
