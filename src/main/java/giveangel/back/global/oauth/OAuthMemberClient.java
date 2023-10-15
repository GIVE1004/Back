package giveangel.back.global.oauth;

import giveangel.back.domain.member.entity.Member;

public interface OAuthMemberClient {

	OAuthServerType getOAuthServerType();

	Member fetch(String authCode);

}
