package giveangel.back.domain.charity.service.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import giveangel.back.domain.charity.entity.Asset;
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
public class AssetInfo {

	private Long totalSum;
	private Long land;
	private Long building;
	private Long stock;
	private Long finance;
	private Long etc;


	public static AssetInfo of(Asset asset) {
		return AssetInfo.builder()
			.totalSum(asset.getTotalSum())
			.land(asset.getTotalLand())
			.building(asset.getTotalBuilding())
			.stock(asset.getTotalStock())
			.finance(asset.getTotalFinance())
			.etc(asset.getTotalEtc())
			.build();
	}

}
