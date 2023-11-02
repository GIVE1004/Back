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
	private List<String> tableHead;

	// 최근을 포함한 3년 치
	private List<List<Long>> tableData;

	public static CharityFinanceInfo of( List<Asset> assets , List<Profit> profits , List<Expense> expenses) {
		ArrayList<String> tableHead = new ArrayList<>();
		tableHead.add("PERIOD");

		ArrayList<List<Long>> tableData = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			ArrayList<Long> data = new ArrayList<>();

			Asset asset = assets.get(i);
			Profit profit = profits.get(i);
			Expense expense = expenses.get(i);

			tableHead.add(String.valueOf(asset.getBaseYearMonth() / 100));

			data.add(asset.getTotalSum());
			data.add(asset.getTotalDebt());
			data.add(profit.getPublicBusinessSum());
			data.add(profit.getPublicBusinessDonation());
			data.add(expense.getPublicTotalSum());
			data.add(expense.getPublicBusinessDistributionSum());

			tableData.add(data);
		}

		return CharityFinanceInfo.builder()
			.totalAsset(assets.get(0).getTotalSum())
			.debt(assets.get(0).getTotalDebt())
			.netAsset(assets.get(0).getTotalNetSum())
			.tableHead(tableHead)
			.tableData(tableData)
			.build();
	}
}
