package giveangel.back.global.oauth.component;

import giveangel.back.domain.member.entity.Member;
import giveangel.back.global.oauth.vendor.OAuthServerType;

public interface OAuthMemberClient {

	OAuthServerType getOAuthServerType();

	Member fetch(String authCode);

}
