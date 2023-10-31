package giveangel.back.domain.charity.service;

import static giveangel.back.domain.charity.exception.CharityErrorCode.NOT_EXISTS_CHARITY;

import giveangel.back.domain.charity.entity.Asset;
import giveangel.back.domain.charity.entity.Expense;
import giveangel.back.domain.charity.entity.Profit;
import giveangel.back.domain.charity.exception.CharityException;
import giveangel.back.domain.charity.repository.AssetRepository;
import giveangel.back.domain.charity.repository.CharityRepository;
import giveangel.back.domain.charity.repository.ExpenseRepository;
import giveangel.back.domain.charity.repository.ProfitRepository;
import giveangel.back.domain.charity.service.dto.CharityFinanceInfo;
import giveangel.back.domain.charity.service.dto.CharityInfo;
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

}
