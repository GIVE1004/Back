package giveangel.back.domain.member.entity;

import giveangel.back.global.oauth.vendor.enums.OAuthServerType;

public enum MemberRole {
	MEMBER, ADMIN;

	public static MemberRole fromName(String roleName) {
		return MemberRole.valueOf(roleName.toUpperCase());
	}

}
