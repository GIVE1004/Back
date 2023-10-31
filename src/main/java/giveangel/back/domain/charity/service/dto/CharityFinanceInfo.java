package giveangel.back.domain.charity.service.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import giveangel.back.domain.charity.entity.Asset;
import giveangel.back.domain.charity.entity.Expense;
import giveangel.back.domain.charity.entity.Profit;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonNaming(SnakeCaseStrategy.class)
public class CharityFinanceInfo {

	// 최근 데이터
	private Long totalAsset;
	private Long debt;
	private Long netAsset;

	// 최근을 포함한 3년 치
	private List<Detail> threeYears;

	public static CharityFinanceInfo of( List<Asset> assets , List<Profit> profits , List<Expense> expenses) {
		ArrayList<Detail> threeYears = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			Asset asset = assets.get(i);
			Profit profit = profits.get(i);
			Expense expense = expenses.get(i);

			threeYears.add(Detail.builder()
				.period(String.valueOf(asset.getBaseYearMonth() / 100))
				.asset(asset.getTotalSum())
				.debt(asset.getTotalDebt())
				.bizProfit(profit.getPublicBusinessSum())
				.donation(profit.getPublicBusinessDonation())
				.bizCost(expense.getPublicTotalSum())
				.distributionCost(expense.getPublicBusinessDistributionSum())
				.build());
		}

		return CharityFinanceInfo.builder()
			.totalAsset(assets.get(0).getTotalSum())
			.debt(assets.get(0).getTotalDebt())
			.netAsset(assets.get(0).getTotalNetSum())
			.threeYears(threeYears)
			.build();
	}


	@Builder
	private static record Detail(Long asset,
								 String period,
								 Long debt,
								 Long bizProfit,
								 Long donation,
								 Long bizCost,
								 Long distributionCost) {
	}
}
