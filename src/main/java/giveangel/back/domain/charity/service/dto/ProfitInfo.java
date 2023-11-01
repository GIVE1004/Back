package giveangel.back.domain.charity.service.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import giveangel.back.domain.charity.entity.Profit;
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
public class ProfitInfo {

	private Long profitId;
	private Long charityId;
	private Long bizSum;
	private Long bizDonation;
	private Long bizSubsidy;
	private Long bizMembership;
	private Long bizEtc;
	private Long nonBiz;
	private Long reversal;
	private Long totalSum;
	private String date;

	public static ProfitInfo of(Profit profit) {
		return ProfitInfo.builder()
			.profitId(profit.getId())
			.charityId(profit.getCharity().getId())
			.bizSum(profit.getPublicBusinessSum())
			.bizDonation(profit.getPublicBusinessDonation())
			.bizSubsidy(profit.getPublicBusinessSubsidy())
			.bizMembership(profit.getPublicBusinessMembershipFee())
			.bizEtc(profit.getEtcBusinessEtc())
			.nonBiz(profit.getPublicNonBusiness())
			.reversal(profit.getPublicReserveFundsReversal())
			.totalSum(profit.getPublicTotalSum())
			.date(String.valueOf(profit.getBaseYearMonth()))
			.build();
	}
}
