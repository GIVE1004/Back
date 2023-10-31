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
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "expenses")
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "expense_id", nullable = false)
	private Long id;

	@NotNull
	@Column(name = "base_year_month", nullable = false)
	private Integer baseYearMonth;

	@NotNull
	@Column(name = "expense_public_total_sum", nullable = false)
	private Long publicTotalSum;

	@NotNull
	@Column(name = "expense_public_total_business", nullable = false)
	private Long publicTotalBusiness;

	@NotNull
	@Column(name = "expense_public_total_general", nullable = false)
	private Long publicTotalGeneral;

	@NotNull
	@Column(name = "expense_public_total_fund_raising", nullable = false)
	private Long publicTotalFundRaising;

	@NotNull
	@Column(name = "expense_public_business_sum", nullable = false)
	private Long publicBusinessSum;

	@NotNull
	@Column(name = "expense_public_business_business", nullable = false)
	private Long publicBusinessBusiness;

	@NotNull
	@Column(name = "expense_public_business_general", nullable = false)
	private Long publicBusinessGeneral;

	@NotNull
	@Column(name = "expense_public_business_fund_raising", nullable = false)
	private Long publicBusinessFundRaising;

	@NotNull
	@Column(name = "expense_public_business_distribution_sum", nullable = false)
	private Long publicBusinessDistributionSum;

	@NotNull
	@Column(name = "expense_public_business_distribution_business", nullable = false)
	private Long publicBusinessDistributionBusiness;

	@NotNull
	@Column(name = "expense_public_business_distribution_general", nullable = false)
	private Long publicBusinessDistributionGeneral;

	@NotNull
	@Column(name = "expense_public_business_distribution_fund_raising", nullable = false)
	private Long publicBusinessDistributionFundRaising;

	@NotNull
	@Column(name = "expense_public_business_distribution_domestic_sum", nullable = false)
	private Long publicBusinessDistributionDomesticSum;

	@NotNull
	@Column(name = "expense_public_business_distribution_domestic_business", nullable = false)
	private Long publicBusinessDistributionDomesticBusiness;

	@NotNull
	@Column(name = "expense_public_business_distribution_domestic_general", nullable = false)
	private Long publicBusinessDistributionDomesticGeneral;

	@NotNull
	@Column(name = "expense_public_business_distribution_domestic_fund_raising", nullable = false)
	private Long publicBusinessDistributionDomesticFundRaising;

	@NotNull
	@Column(name = "expense_public_business_distribution_overseas_sum", nullable = false)
	private Long publicBusinessDistributionOverseasSum;

	@NotNull
	@Column(name = "expense_public_business_distribution_overseas_business", nullable = false)
	private Long publicBusinessDistributionOverseasBusiness;

	@NotNull
	@Column(name = "expense_public_business_distribution_overseas_general", nullable = false)
	private Long publicBusinessDistributionOverseasGeneral;

	@NotNull
	@Column(name = "expense_public_business_distribution_overseas_fund_raising", nullable = false)
	private Long publicBusinessDistributionOverseasFundRaising;

	@NotNull
	@Column(name = "expense_public_business_labor_sum", nullable = false)
	private Long publicBusinessLaborSum;

	@NotNull
	@Column(name = "expense_public_business_labor_business", nullable = false)
	private Long publicBusinessLaborBusiness;

	@NotNull
	@Column(name = "expense_public_business_labor_general", nullable = false)
	private Long publicBusinessLaborGeneral;

	@NotNull
	@Column(name = "expense_public_business_labor_fund_raising", nullable = false)
	private Long publicBusinessLaborFundRaising;

	@NotNull
	@Column(name = "expense_public_business_facility_sum", nullable = false)
	private Long publicBusinessFacilitySum;

	@NotNull
	@Column(name = "expense_public_business_facility_business", nullable = false)
	private Long publicBusinessFacilityBusiness;

	@NotNull
	@Column(name = "expense_public_business_facility_general", nullable = false)
	private Long publicBusinessFacilityGeneral;

	@NotNull
	@Column(name = "expense_public_business_facility_fund_raising", nullable = false)
	private Long publicBusinessFacilityFundRaising;

	@NotNull
	@Column(name = "expense_public_business_etc_sum", nullable = false)
	private Long publicBusinessEtcSum;

	@NotNull
	@Column(name = "expense_public_business_etc_business", nullable = false)
	private Long publicBusinessEtcBusiness;

	@NotNull
	@Column(name = "expense_public_business_etc_general", nullable = false)
	private Long publicBusinessEtcGeneral;

	@NotNull
	@Column(name = "expense_public_business_etc_fund_raising", nullable = false)
	private Long publicBusinessEtcFundRaising;

	@NotNull
	@Column(name = "expense_public_non_business_sum", nullable = false)
	private Long publicNonBusinessSum;

	@NotNull
	@Column(name = "expense_public_non_business_business", nullable = false)
	private Long publicNonBusinessBusiness;

	@NotNull
	@Column(name = "expense_public_non_business_general", nullable = false)
	private Long publicNonBusinessGeneral;

	@NotNull
	@Column(name = "expense_public_non_business_fund_raising", nullable = false)
	private Long publicNonBusinessFundRaising;

	@NotNull
	@Column(name = "expense_public_reserve_funds_transfer_sum", nullable = false)
	private Long publicReserveFundsTransferSum;

	@NotNull
	@Column(name = "expense_public_reserve_funds_transfer_business", nullable = false)
	private Long publicReserveFundsTransferBusiness;

	@NotNull
	@Column(name = "expense_public_reserve_funds_transfer_general", nullable = false)
	private Long publicReserveFundsTransferGeneral;

	@NotNull
	@Column(name = "expense_public_reserve_funds_transfer_fund_raising", nullable = false)
	private Long publicReserveFundsTransferFundRaising;

	@NotNull
	@Column(name = "expense_etc_total_sum", nullable = false)
	private Long etcTotalSum;

	@NotNull
	@Column(name = "expense_etc_business_finance_sum", nullable = false)
	private Long etcBusinessFinanceSum;

	@NotNull
	@Column(name = "expense_etc_business_finance_etc", nullable = false)
	private Long etcBusinessFinanceEtc;

	@NotNull
	@Column(name = "expense_etc_business_real_estate_sum", nullable = false)
	private Long etcBusinessRealEstateSum;

	@NotNull
	@Column(name = "expense_etc_business_real_estate_rental", nullable = false)
	private Long etcBusinessRealEstateRental;

	@NotNull
	@Column(name = "expense_etc_business_real_estate_sale", nullable = false)
	private Long etcBusinessRealEstateSale;

	@NotNull
	@Column(name = "expense_etc_business_etc", nullable = false)
	private Long etcBusinessEtc;

	@NotNull
	@Column(name = "expense_etc_non_business", nullable = false)
	private Long etcNonBusiness;

	@NotNull
	@Column(name = "expense_etc_reserve_funds_transfer", nullable = false)
	private Long etcReserveFundsTransfer;
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "public_interest_corporation_id", nullable = false)
	private Charity charity;

}