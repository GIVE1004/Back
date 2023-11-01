package giveangel.back.domain.charity.service;

import static giveangel.back.domain.charity.exception.CharityErrorCode.NOT_EXISTS_CHARITY;

import giveangel.back.domain.charity.entity.Charity;
import giveangel.back.domain.charity.exception.CharityException;
import giveangel.back.domain.charity.repository.AssetRepository;
import giveangel.back.domain.charity.repository.CharityRepository;
import giveangel.back.domain.charity.repository.ExpenseRepository;
import giveangel.back.domain.charity.repository.ProfitRepository;
import giveangel.back.domain.charity.service.dto.CharityFinanceInfo;
import giveangel.back.domain.charity.service.dto.CharityInfo;
import giveangel.back.domain.charity.service.dto.CharityNewsInfo;
import giveangel.back.global.api.news.NaverNewsClient;
import giveangel.back.global.api.news.News;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CharityService {

	private final CharityRepository charityRepository;
	private final ProfitRepository profitRepository;
	private final AssetRepository assetRepository;
	private final ExpenseRepository expenseRepository;
	private final NaverNewsClient naverNewsClient;

	public CharityInfo inquiryCharity(Long charityId) {
		return CharityInfo.of(charityRepository.findById(charityId)
			.orElseThrow(() -> new CharityException(NOT_EXISTS_CHARITY)));
	}

	public CharityFinanceInfo inquiryCharityFinance(Long charityId) {
		return CharityFinanceInfo.of(
			assetRepository.findRecentThreeYearAssetByCharityId(charityId),
			profitRepository.findRecentThreeYearProfitByCharityId(charityId),
			expenseRepository.findRecentThreeYearExpenseByCharityId(charityId)
		);
	}

	public CharityNewsInfo inquiryCharityNews(Long charityId) {
		Charity charity = charityRepository.findById(charityId)
			.orElseThrow(() -> new CharityException(NOT_EXISTS_CHARITY));

		return CharityNewsInfo.builder()
			.charityId(charityId)
			.news(naverNewsClient.searchRecentNews(charity.getName(), 5))
			.build(); 			
	}
}
