package giveangel.back.global.oauth;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class OAuthCodeUrlProviderComposite {

	private final Map<OAuthServerType, OAuthCodeUrlProvider> providerMap;

	public OAuthCodeUrlProviderComposite(Set<OAuthCodeUrlProvider> providers) {
		this.providerMap = providers.stream()
			.collect(
				toMap(OAuthCodeUrlProvider::getOAuthServerType, identity()));
	}

	public String provide(OAuthServerType oAuthServerType) {
		return getProvider(oAuthServerType).provide();
	}

	private OAuthCodeUrlProvider getProvider(OAuthServerType oAuthServerType) {
		return Optional.ofNullable(providerMap.get(oAuthServerType))
			.orElseThrow(() -> new OAuthException("지원하지 않는 소셜 로그인"));
	}

}
