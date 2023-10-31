package giveangel.back.global.config;

import giveangel.back.global.api.news.NaverNewsApiClient;
import giveangel.back.global.oauth.vendor.google.client.GoogleApiClient;
import giveangel.back.global.oauth.vendor.kakao.client.KakaoApiClient;
import giveangel.back.global.oauth.vendor.naver.client.NaverApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpInterfaceConfig {

	@Bean
	public KakaoApiClient kakaoApiClient() {
		return createHttpInterface(KakaoApiClient.class);
	}
	@Bean
	public NaverApiClient naverApiClient() { return createHttpInterface(NaverApiClient.class); }
	@Bean
	public GoogleApiClient googleApiClient() { return createHttpInterface(GoogleApiClient.class); }

	@Bean
	public NaverNewsApiClient naverNewsApiClient() { return createHttpInterface(NaverNewsApiClient.class); }

	private <T> T createHttpInterface(Class<T> clazz) {
		WebClient webClient = WebClient.create();
		HttpServiceProxyFactory build = HttpServiceProxyFactory
			.builder(WebClientAdapter.forClient(webClient)).build();
		return build.createClient(clazz);
	}

}
