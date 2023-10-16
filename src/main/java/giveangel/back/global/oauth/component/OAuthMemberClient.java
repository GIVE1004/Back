package giveangel.back.global.oauth.component;

import giveangel.back.domain.member.entity.Member;
import giveangel.back.global.oauth.vendor.enums.OAuthServerType;

public interface OAuthMemberClient {

	OAuthServerType getOAuthServerType();

	Member fetch(OAuthServerType oAuthServerType, String authCode);

}
