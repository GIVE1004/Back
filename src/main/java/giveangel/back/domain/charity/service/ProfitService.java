package giveangel.back.domain.charity.service;

import giveangel.back.domain.charity.entity.Profit;
import giveangel.back.domain.charity.repository.ProfitRepository;
import giveangel.back.domain.charity.service.dto.PublicProfitInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProfitService {

	private final ProfitRepository profitRepository;


	// 최신 연도로 조회 (한개)
	public PublicProfitInfo inquiryPublicProfit(Long charityId) {
		return PublicProfitInfo.of(profitRepository.findRecentProfitByCharityId(charityId)
			.orElse(new Profit()));
	}


	public void inquiryProfit(Long charityId) {

	}
}
