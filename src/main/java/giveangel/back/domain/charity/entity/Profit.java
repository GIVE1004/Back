package giveangel.back.domain.charity.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "profits",
	uniqueConstraints = @UniqueConstraint(
		name = "profit_corporation_year_uk",
		columnNames = {"public_interest_corporation_id", "base_year_month"}
	)
)
public class Profit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "profit_id", nullable = false)
	private Long id;

	@NotNull
	@Column(name = "base_year_month", nullable = false)
	private Integer baseYearMonth;

	@NotNull
	@Column(name = "profit_public_total_sum", nullable = false)
	private Long publicTotalSum;

	@NotNull
	@Column(name = "profit_public_business_sum", nullable = false)
	private Long publicBusinessSum;

	@NotNull
	@Column(name = "profit_public_business_donation", nullable = false)
	private Long publicBusinessDonation;

	@NotNull
	@Column(name = "profit_public_business_donation_individual", nullable = false)
	private Long publicBusinessDonationIndividual;

	@NotNull
	@Column(name = "profit_public_business_donation_profit_corp", nullable = false)
	private Long publicBusinessDonationProfitCorp;

	@NotNull
	@Column(name = "profit_public_business_donation_public_corp", nullable = false)
	private Long publicBusinessDonationPublicCorp;

	@NotNull
	@Column(name = "profit_public_business_donation_etc", nullable = false)
	private Long publicBusinessDonationEtc;

	@NotNull
	@Column(name = "profit_public_business_donation_item", nullable = false)
	private Long publicBusinessDonationItem;

	@NotNull
	@Column(name = "profit_public_business_subsidy", nullable = false)
	private Long publicBusinessSubsidy;

	@NotNull
	@Column(name = "profit_public_business_membership_fee", nullable = false)
	private Long publicBusinessMembershipFee;

	@NotNull
	@Column(name = "profit_public_business_etc", nullable = false)
	private Long publicBusinessEtc;

	@NotNull
	@Column(name = "profit_public_non_business", nullable = false)
	private Long publicNonBusiness;

	@NotNull
	@Column(name = "profit_public_reserve_funds_reversal", nullable = false)
	private Long publicReserveFundsReversal;

	@NotNull
	@Column(name = "profit_etc_total_sum", nullable = false)
	private Long etcTotalSum;

	@NotNull
	@Column(name = "profit_etc_business_finance_sum", nullable = false)
	private Long etcBusinessFinanceSum;

	@NotNull
	@Column(name = "profit_etc_business_finance_interest", nullable = false)
	private Long etcBusinessFinanceInterest;

	@NotNull
	@Column(name = "profit_etc_business_finance_dividend", nullable = false)
	private Long etcBusinessFinanceDividend;

	@NotNull
	@Column(name = "profit_etc_business_finance_etc", nullable = false)
	private Long etcBusinessFinanceEtc;

	@NotNull
	@Column(name = "profit_etc_business_real_estate_sum", nullable = false)
	private Long etcBusinessRealEstateSum;

	@NotNull
	@Column(name = "profit_etc_business_real_estate_rental", nullable = false)
	private Long etcBusinessRealEstateRental;

	@NotNull
	@Column(name = "profit_etc_business_real_estate_sale", nullable = false)
	private Long etcBusinessRealEstateSale;

	@NotNull
	@Column(name = "profit_etc_business_etc", nullable = false)
	private Long etcBusinessEtc;

	@NotNull
	@Column(name = "profit_etc_non_business", nullable = false)
	private Long etcNonBusiness;

	@NotNull
	@Column(name = "profit_etc_reserve_funds_reversal", nullable = false)
	private Long etcReserveFundsReversal;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "public_interest_corporation_id", nullable = false)
	private Charity charity;

}