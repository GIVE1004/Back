package giveangel.back.global.oauth.vendor.enums;

public enum OAuthServerType {
	KAKAO, NAVER, GOOGLE;

	public static OAuthServerType fromName(String providerName) {
		return OAuthServerType.valueOf(providerName.toUpperCase());
	}
}
