package giveangel.back.global.oauth;

public interface OAuthCodeUrlProvider {

	OAuthServerType getOAuthServerType();

	String provide();

}
