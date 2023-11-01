package giveangel.back.domain.charity.controller;

import giveangel.back.domain.charity.service.AssetService;
import giveangel.back.domain.charity.service.dto.AssetInfo;
import giveangel.back.global.common.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/charities/{charityId}/assets")
@RestController
public class AssetController {

	private final AssetService assetService;

	@GetMapping("/current")
	public ResponseEntity<Message<AssetInfo>> current(@PathVariable Long charityId) {
		return ResponseEntity.ok()
			.body(Message.success(assetService.inquiryCurrentAsset(charityId)));
	}
}
