package giveangel.back.global.oauth.vendor.enums;

public enum OAuthServerType {
	KAKAO, NAVER;

	public static OAuthServerType fromName(String providerName) {
		return OAuthServerType.valueOf(providerName.toUpperCase());
	}
}
