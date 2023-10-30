package giveangel.back.global.oauth.vendor.google.authcode;

import giveangel.back.global.oauth.component.OAuthCodeUrlProvider;
import giveangel.back.global.oauth.vendor.enums.OAuthServerType;
import giveangel.back.global.oauth.vendor.google.GoogleOAuthProps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class GoogleOAuthCodeUrlProvider implements OAuthCodeUrlProvider {

	private final GoogleOAuthProps props;

	@Override
	public OAuthServerType support() {
		return OAuthServerType.GOOGLE;
	}

	@Override
	public String provide(OAuthServerType oAuthServerType) {
		return UriComponentsBuilder
			.fromUriString("https://accounts.google.com/o/oauth2/v2/auth")
			.queryParam("response_type","code")
			.queryParam("client_id",props.clientId())
			.queryParam("redirect_uri",props.redirectUri())
			.queryParam("scope",String.join(" ",props.scope()))
			.toUriString();
	}
}
