package giveangel.back.domain.charity.service;

import static giveangel.back.domain.charity.exception.CharityErrorCode.NOT_EXISTS_CHARITY;

import giveangel.back.domain.charity.exception.CharityException;
import giveangel.back.domain.charity.repository.ProfitRepository;
import giveangel.back.domain.charity.service.dto.ProfitInfo;
import giveangel.back.domain.charity.service.dto.PublicProfitInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProfitService {

	private final ProfitRepository profitRepository;

	// 최신 연도로 조회 (한개)
	public PublicProfitInfo inquiryCurrentPublicProfit(Long charityId) {
		return PublicProfitInfo.of(profitRepository.findRecentProfitByCharityId(charityId)
			.orElseThrow(() -> new CharityException(NOT_EXISTS_CHARITY)));
	}

	public ProfitInfo inquiryCurrentProfit(Long charityId) {
		return ProfitInfo.of(profitRepository.findRecentProfitByCharityId(charityId)
				.orElseThrow(() -> new CharityException(NOT_EXISTS_CHARITY)));
	}
}
