package giveangel.back.domain.charity.service.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import giveangel.back.domain.charity.entity.Profit;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
@JsonNaming(SnakeCaseStrategy.class)
public class PublicProfitInfo {

	private Long profitId;
	private Long charityId;
	private Long donationSum;
	private Long donationIndividual;
	private Long donationProfitCorp;
	private Long donationPublicCorp;
	private Long donationEtc;
	private Long subsidy;
	private Long profitMembership;
	private Long profitPublicBusinessEtc;
	private String date;

	public static PublicProfitInfo of(Profit profit) {
		return PublicProfitInfo.builder()
			.profitId(profit.getId())
			.charityId(profit.getCharity().getId())
			.donationSum(profit.getPublicBusinessDonation())
			.donationIndividual(profit.getPublicBusinessDonationIndividual())
			.donationProfitCorp(profit.getPublicBusinessDonationProfitCorp())
			.donationPublicCorp(profit.getPublicBusinessDonationPublicCorp())
			.donationEtc(profit.getPublicBusinessDonationEtc())
			.subsidy(profit.getPublicBusinessSubsidy())
			.profitMembership(profit.getPublicBusinessMembershipFee())
			.profitPublicBusinessEtc(profit.getPublicBusinessEtc())
			.date(String.valueOf(profit.getBaseYearMonth()))
			.build();
	}
}
