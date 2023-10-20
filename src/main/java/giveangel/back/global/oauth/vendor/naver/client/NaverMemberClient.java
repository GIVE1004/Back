package giveangel.back.global.oauth.vendor.naver.client;

import giveangel.back.domain.member.entity.Member;
import giveangel.back.global.oauth.component.OAuthMemberClient;
import giveangel.back.global.oauth.vendor.enums.OAuthServerType;
import giveangel.back.global.oauth.vendor.kakao.dto.NaverToken;
import giveangel.back.global.oauth.vendor.naver.NaverOAuthProps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RequiredArgsConstructor
@Component
public class NaverMemberClient implements OAuthMemberClient {

	private final NaverApiClient naverApiClient;
	private final NaverOAuthProps props;

	@Override
	public OAuthServerType getOAuthServerType() {
		return OAuthServerType.NAVER;
	}

	@Override
	public Member fetch(OAuthServerType oAuthServerType, String authCode) {
		NaverToken token = naverApiClient.fetchToken(tokenRequestParams(authCode));

		return naverApiClient.fetchMember("Bearer " + token.accessToken()).toDomain();
	}

	private MultiValueMap<String, String> tokenRequestParams(String authCode) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", props.clientId());
		params.add("code", authCode);
		params.add("state",props.state());
		params.add("client_secret", props.clientSecret());
		return params;
	}
}
