package giveangel.back.global.oauth.vendor.kakao.authcode;

import giveangel.back.global.oauth.component.OAuthCodeUrlProvider;
import giveangel.back.global.oauth.vendor.enums.OAuthServerType;
import giveangel.back.global.oauth.vendor.google.GoogleOAuthProps;
import giveangel.back.global.oauth.vendor.kakao.KakaoOAuthProps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class KakaoOAuthCodeUrlProvider implements OAuthCodeUrlProvider {

	private final KakaoOAuthProps props;

	@Override
	public OAuthServerType support() {
		return OAuthServerType.KAKAO;
	}

	@Override
	public String provide(OAuthServerType oAuthServerType) {
		return UriComponentsBuilder
			.fromUriString("https://kauth.kakao.com/oauth/authorize")
			.queryParam("response_type","code")
			.queryParam("client_id",props.clientId())
			.queryParam("redirect_uri",props.redirectUri())
			.queryParam("scope",String.join(",",props.scope()))
			.toUriString();
	}
}
