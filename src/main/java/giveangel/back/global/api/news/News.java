package giveangel.back.global.api.news;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class News {

	private String title;
	private String link;
	private String thumbnail;
	private String description;
	private String publisher;
	private LocalDateTime pubDate;

}
