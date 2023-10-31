package giveangel.back.domain.charity.service;

import static giveangel.back.domain.charity.exception.CharityErrorCode.NOT_EXISTS_CHARITY;

import giveangel.back.domain.charity.exception.CharityException;
import giveangel.back.domain.charity.repository.AssetRepository;
import giveangel.back.domain.charity.service.dto.AssetInfo;
import giveangel.back.domain.charity.service.dto.ProfitInfo;
import giveangel.back.domain.charity.service.dto.PublicProfitInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AssetService {

	private final AssetRepository assetRepository;

	public AssetInfo inquiryCurrentAsset(Long charityId) {
		return AssetInfo.of(assetRepository.findRecentAssetByCharityId(charityId)
			.orElseThrow(() -> new CharityException(NOT_EXISTS_CHARITY)));
	}

}
