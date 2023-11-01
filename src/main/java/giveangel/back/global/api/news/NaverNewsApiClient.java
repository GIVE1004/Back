package giveangel.back.global.api.news;


import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface NaverNewsApiClient {

	// 뉴스 검색하기
	@GetExchange("https://openapi.naver.com/v1/search/news.json")
	NaverNewsResponse fetchNews(
		@RequestParam(value = "params") MultiValueMap<String, String> params,
		@RequestHeader(name = "X-Naver-Client-Id") String clientId,
		@RequestHeader(name = "X-Naver-Client-Secret") String clientSecret
	);
}
