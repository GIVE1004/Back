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
@Setter
@Entity
@Table(name = "assets")
public class Asset {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "asset_id", nullable = false)
	private Long id;

	@NotNull
	@Column(name = "base_year_month", nullable = false)
	private Integer baseYearMonth;

	@NotNull
	@Column(name = "asset_total_sum", nullable = false)
	private Long totalSum;

	@NotNull
	@Column(name = "asset_total_debt", nullable = false)
	private Long totalDebt;

	@NotNull
	@Column(name = "asset_total_net_sum", nullable = false)
	private Long totalNetSum;

	@NotNull
	@Column(name = "asset_total_net_basic", nullable = false)
	private Long totalNetBasic;

	@NotNull
	@Column(name = "asset_total_net_regular", nullable = false)
	private Long totalNetRegular;

	@NotNull
	@Column(name = "asset_total_net_adjustment", nullable = false)
	private Long totalNetAdjustment;

	@NotNull
	@Column(name = "asset_total_land", nullable = false)
	private Long totalLand;

	@NotNull
	@Column(name = "asset_total_building", nullable = false)
	private Long totalBuilding;

	@NotNull
	@Column(name = "asset_total_stock", nullable = false)
	private Long totalStock;

	@NotNull
	@Column(name = "asset_total_finance", nullable = false)
	private Long totalFinance;

	@NotNull
	@Column(name = "asset_total_etc", nullable = false)
	private Long totalEtc;

	@NotNull
	@Column(name = "asset_public_sum", nullable = false)
	private Long publicSum;

	@NotNull
	@Column(name = "asset_public_debt", nullable = false)
	private Long publicDebt;

	@NotNull
	@Column(name = "asset_public_net_sum", nullable = false)
	private Long publicNetSum;

	@NotNull
	@Column(name = "asset_public_net_basic", nullable = false)
	private Long publicNetBasic;

	@NotNull
	@Column(name = "asset_public_net_regular", nullable = false)
	private Long publicNetRegular;

	@NotNull
	@Column(name = "asset_public_net_adjustment", nullable = false)
	private Long publicNetAdjustment;

	@NotNull
	@Column(name = "asset_public_land", nullable = false)
	private Long publicLand;

	@NotNull
	@Column(name = "asset_public_building", nullable = false)
	private Long publicBuilding;

	@NotNull
	@Column(name = "asset_public_stock", nullable = false)
	private Long publicStock;

	@NotNull
	@Column(name = "asset_public_finance", nullable = false)
	private Long publicFinance;

	@NotNull
	@Column(name = "asset_public_etc", nullable = false)
	private Long publicEtc;

	@NotNull
	@Column(name = "asset_etc_sum", nullable = false)
	private Long etcSum;

	@NotNull
	@Column(name = "asset_etc_debt", nullable = false)
	private Long etcDebt;

	@NotNull
	@Column(name = "asset_etc_net_sum", nullable = false)
	private Long etcNetSum;

	@NotNull
	@Column(name = "asset_etc_net_basic", nullable = false)
	private Long etcNetBasic;

	@NotNull
	@Column(name = "asset_etc_net_regular", nullable = false)
	private Long etcNetRegular;

	@NotNull
	@Column(name = "asset_etc_net_adjustment", nullable = false)
	private Long etcNetAdjustment;

	@NotNull
	@Column(name = "asset_etc_land", nullable = false)
	private Long etcLand;

	@NotNull
	@Column(name = "asset_etc_building", nullable = false)
	private Long etcBuilding;

	@NotNull
	@Column(name = "asset_etc_stock", nullable = false)
	private Long etcStock;

	@NotNull
	@Column(name = "asset_etc_finance", nullable = false)
	private Long etcFinance;

	@NotNull
	@Column(name = "asset_etc_etc", nullable = false)
	private Long etcEtc;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "public_interest_corporation_id", nullable = false)
	private Charity charity;

}