package giveangel.back.global.oauth;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import giveangel.back.domain.member.entity.Member;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class OAuthMemberClientComposite {

	private final Map<OAuthServerType, OAuthMemberClient> clientMap;

	public OAuthMemberClientComposite(Set<OAuthMemberClient> clients) {
		this.clientMap = clients.stream()
			.collect(
				toMap(OAuthMemberClient::getOAuthServerType, identity()));
	}

	public Member fetch(OAuthServerType oAuthServerType, String authCode) {
		return getClient(oAuthServerType).fetch(authCode);
	}

	private OAuthMemberClient getClient(OAuthServerType oAuthServerType) {
		return Optional.ofNullable(clientMap.get(oAuthServerType))
			.orElseThrow(() -> new OAuthException("지원하지 않는 소셜 로그인"));
	}

}
