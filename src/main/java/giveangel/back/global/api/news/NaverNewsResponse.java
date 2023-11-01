package giveangel.back.global.api.news;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;

@Builder
public record NaverNewsResponse(
	LocalDateTime lastBuilDate,
	Long total,
	Long start,
	Long display,
	List<Item> items
	) {

	static record Item(
		String title,
		String originallink,
		String link,
		String description,
		String pubDate
	) {
	}
}
