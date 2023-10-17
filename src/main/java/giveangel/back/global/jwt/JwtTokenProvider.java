package giveangel.back.global.jwt;

import static giveangel.back.global.jwt.exception.JwtErrorCode.EXPIRED_TOKEN;
import static giveangel.back.global.jwt.exception.JwtErrorCode.INVALID_TOKEN;

import giveangel.back.domain.member.entity.Member;
import giveangel.back.domain.member.entity.MemberRole;
import giveangel.back.domain.member.entity.OAuthId;
import giveangel.back.global.jwt.exception.JwtException;
import giveangel.back.global.oauth.vendor.enums.OAuthServerType;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import java.time.Duration;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

	private final JwtProps props;

	private static final String CLAIM_EMAIL = "email";
	private static final String CLAIM_VENDOR = "vendor";
	private static final String CLAIM_NICKNAME = "nickname";
	private static final String CLAIM_ROLE = "role";
	private static final String CLAIM_PROFILE_IMG = "profileImg";

	// 액세스 토큰 발급
	public String issueAccessToken(Member member) {

		Claims claims = Jwts.claims()
			.id(String.valueOf(member.getId()))
			.add(CLAIM_EMAIL, member.getOAuthId().getOauthServerId())
			.add(CLAIM_VENDOR, member.getOAuthId().getOauthServerType())
			.add(CLAIM_PROFILE_IMG, member.getOAuthId().getOauthServerType())
			.add(CLAIM_NICKNAME, member.getNickname())
			.add(CLAIM_ROLE, member.getRole())
			.build();

		return issueToken(claims, props.accessExpiration(), props.accessKey());
	}

	// 리프레시 토큰 발급
	public String issueRefreshToken() {
		return issueToken(null, props.accessExpiration(), props.accessKey());
	}

	private String issueToken(Claims claims, Duration expiration, String secretKey) {
		Date now = new Date();

		return Jwts.builder()
			.claims(claims)
			.issuedAt(now)
			.expiration(new Date(now.getTime() + expiration.toMillis()))
			.signWith(Keys.hmacShaKeyFor(secretKey.getBytes()))
			.compact();
	}

	// 토큰을 회원 정보로 파싱
	public Member parseAccessToken(String accessToken) {
		Claims payload = parseToken(accessToken, props.accessKey());

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

	public void parseRefreshToken(String refreshToken) {
		parseToken(refreshToken, props.refreshKey());
	}

	private Claims parseToken(String token, String secretKey) {
		Claims payload;

		try {
			payload = Jwts.parser()
				.verifyWith(Keys.hmacShaKeyFor(secretKey.getBytes()))
				.build()
				.parseSignedClaims(token).getPayload();

		} catch (ExpiredJwtException e) {
			throw new JwtException(EXPIRED_TOKEN);
		} catch (MalformedJwtException | SignatureException | SecurityException | IllegalArgumentException e) {
			throw new JwtException(INVALID_TOKEN);
		}

		return payload;
	}


}
