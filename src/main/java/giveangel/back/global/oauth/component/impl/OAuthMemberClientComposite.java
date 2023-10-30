package giveangel.back.global.oauth.component.impl;

import static giveangel.back.global.oauth.exception.OAuthErrorCode.NOT_SUPPORT_VENDOR;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import giveangel.back.domain.member.entity.Member;
import giveangel.back.global.oauth.component.OAuthMemberClient;
import giveangel.back.global.oauth.exception.OAuthErrorCode;
import giveangel.back.global.oauth.exception.OAuthException;
import giveangel.back.global.oauth.vendor.enums.OAuthServerType;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class OAuthMemberClientComposite implements OAuthMemberClient{

	private final Map<OAuthServerType, OAuthMemberClient> clientMap;

	public OAuthMemberClientComposite(Set<OAuthMemberClient> clients) {
		this.clientMap = clients.stream()
			.collect(
				toMap(OAuthMemberClient::getOAuthServerType, identity()));
	}

	@Override
	public OAuthServerType getOAuthServerType() {
		return null;
	}

	public Member fetch(OAuthServerType oAuthServerType, String authCode) {
		return getClient(oAuthServerType).fetch(oAuthServerType,authCode);
	}

	private OAuthMemberClient getClient(OAuthServerType oAuthServerType) {
		return Optional.ofNullable(clientMap.get(oAuthServerType))
			.orElseThrow(() -> new OAuthException(NOT_SUPPORT_VENDOR));
	}

}
