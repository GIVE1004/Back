package giveangel.back.domain.charity.service.dto;

import giveangel.back.global.api.news.News;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Builder
public class CharityNewsInfo {
	private Long charityId;
	private List<News> news;
}
