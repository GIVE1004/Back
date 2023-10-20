package giveangel.back.global.oauth.vendor.naver.authcode;

import giveangel.back.global.oauth.component.OAuthCodeUrlProvider;
import giveangel.back.global.oauth.vendor.enums.OAuthServerType;
import giveangel.back.global.oauth.vendor.kakao.KakaoOAuthProps;
import giveangel.back.global.oauth.vendor.naver.NaverOAuthProps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class NaverOAuthCodeUrlProvider implements OAuthCodeUrlProvider {

	private final NaverOAuthProps props;

	@Override
	public OAuthServerType support() {
		return OAuthServerType.NAVER;
	}

	@Override
	public String provide(OAuthServerType oAuthServerType) {
		return UriComponentsBuilder
			.fromUriString("https://nid.naver.com/oauth2.0/authorize")
			.queryParam("response_type", "code")
			.queryParam("client_id", props.clientId())
			.queryParam("redirect_uri", props.redirectUri())
			.queryParam("state", props.state())
			.toUriString();
	}
}
