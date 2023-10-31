package giveangel.back.global.api.news;

import giveangel.back.global.api.news.NaverNewsResponse.Item;
import giveangel.back.global.api.news.NewsCrawler.NewsSite;
import giveangel.back.global.oauth.vendor.naver.NaverOAuthProps;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RequiredArgsConstructor
@Component
public class NaverNewsClient {

	private final NaverNewsApiClient naverNewsApiClient;
	private final NaverOAuthProps props;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
		"EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);

	public List<News> searchRecentNews(String keyword, int size) {

		NaverNewsResponse response = naverNewsApiClient.
			fetchNews(createParam(keyword, size), props.clientId(), props.clientSecret());

		ArrayList<News> news = new ArrayList<>();

		for (Item item : response.items()) {
			NewsSite newsSite = NewsCrawler.getThumbnailAndSiteName(
				item.originallink());

			news.add(News.builder()
				.title(item.title().replaceAll("<[^>]*>",""))
				.link(item.originallink())
				.description(item.description().replaceAll("<[^>]*>",""))
				.thumbnail(newsSite.thumbnail())
				.publisher(newsSite.siteName())
				.pubDate(LocalDateTime.parse(item.pubDate(), formatter))
				.build());
		}

		return news;
	}

	private MultiValueMap<String, String> createParam(String keyword, int size) {
		LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("query", keyword);
		map.add("display", String.valueOf(size));
		map.add("sort", "date");
		return map;
	}
}
