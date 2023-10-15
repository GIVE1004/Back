package giveangel.back.global.oauth;


import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
public record KakaoToken(
	String tokenType,
	String accessToken,
	String idToken,
	String expiresIn,
	String refreshToken,
	String refreshTokenExpiresIn,
	String scope
) {

}
