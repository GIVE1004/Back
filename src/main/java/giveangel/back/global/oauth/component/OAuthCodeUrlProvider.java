package giveangel.back.global.oauth.component;

import giveangel.back.global.oauth.vendor.enums.OAuthServerType;

public interface OAuthCodeUrlProvider {

	OAuthServerType support();

	String provide(OAuthServerType oAuthServerType);

}
