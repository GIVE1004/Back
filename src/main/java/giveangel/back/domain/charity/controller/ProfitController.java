package giveangel.back.domain.charity.controller;

import giveangel.back.domain.charity.service.ProfitService;
import giveangel.back.domain.charity.service.dto.ProfitInfo;
import giveangel.back.domain.charity.service.dto.PublicProfitInfo;
import giveangel.back.global.common.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/charities/{charityId}/profits")
@RestController
public class ProfitController {

	private final ProfitService profitService;

	@GetMapping("/public-current")
	public ResponseEntity<Message<PublicProfitInfo>> publicCurrent(@PathVariable Long charityId) {
		return ResponseEntity.ok()
			.body(Message.success(profitService.inquiryCurrentPublicProfit(charityId)));
	}

	@GetMapping("/current")
	public ResponseEntity<Message<ProfitInfo>> current(@PathVariable Long charityId) {
		return ResponseEntity.ok()
			.body(Message.success(profitService.inquiryCurrentProfit(charityId)));
	}
}
