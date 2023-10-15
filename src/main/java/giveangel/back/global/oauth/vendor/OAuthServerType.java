package giveangel.back.global.oauth.vendor;

import giveangel.back.global.oauth.exception.OAuthException;

public enum OAuthServerType {
	KAKAO, NAVER;

	public static OAuthServerType fromName(String providerName) {

		OAuthServerType type = null;

		try {
			type = OAuthServerType.valueOf(providerName.toUpperCase());
		} catch (IllegalArgumentException e) {
			new OAuthException("지원하지 않는 소셜 로그인");
		}

		return type;
	}
}
