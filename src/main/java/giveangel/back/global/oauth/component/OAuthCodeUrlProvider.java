package giveangel.back.global.oauth.component;

import giveangel.back.global.oauth.vendor.OAuthServerType;

public interface OAuthCodeUrlProvider {

	OAuthServerType support();

	String provide();

}
