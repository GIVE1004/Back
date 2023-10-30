package giveangel.back.global.oauth.component.impl;

import static giveangel.back.global.oauth.exception.OAuthErrorCode.NOT_SUPPORT_VENDOR;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import giveangel.back.global.oauth.component.OAuthCodeUrlProvider;
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
public class OAuthCodeUrlProviderComposite implements OAuthCodeUrlProvider {

	private final Map<OAuthServerType, OAuthCodeUrlProvider> providerMap;

	public OAuthCodeUrlProviderComposite(Set<OAuthCodeUrlProvider> providers) {
		this.providerMap = providers.stream()
			.collect(
				toMap(OAuthCodeUrlProvider::support, identity()));
	}

	@Override
	public OAuthServerType support() {
		return null;
	}

	@Override
	public String provide(OAuthServerType oAuthServerType) {
		return getProvider(oAuthServerType).provide(oAuthServerType);
	}

	private OAuthCodeUrlProvider getProvider(OAuthServerType oAuthServerType) {
		return Optional.ofNullable(providerMap.get(oAuthServerType))
			.orElseThrow(() -> new OAuthException(NOT_SUPPORT_VENDOR));
	}

}
