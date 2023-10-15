package giveangel.back.global.oauth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class KakaoOAuthCodeUrlProvider implements OAuthCodeUrlProvider {

	private final KakaoOAuthProps props;

	@Override
	public OAuthServerType getOAuthServerType() {
		return OAuthServerType.KAKAO;
	}

	@Override
	public String provide() {
		return UriComponentsBuilder
			.fromUriString("https://kauth.kakao.com/oauth/authorize")
			.queryParam("response_type","code")
			.queryParam("client_id",props.clientId())
			.queryParam("redirect_uri",props.redirectUri())
			.queryParam("scope",String.join(",",props.scope()))
			.toUriString();
	}
}
