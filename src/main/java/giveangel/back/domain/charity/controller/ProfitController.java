package giveangel.back.domain.charity.controller;

import giveangel.back.domain.charity.service.ProfitService;
import giveangel.back.domain.charity.service.dto.PublicProfitInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/charities/{charityId}/profit")
@RestController
public class ProfitController {

	private final ProfitService profitService;

	@GetMapping("/public-detail")
	public ResponseEntity<PublicProfitInfo> publicDetail(@PathVariable Long charityId) {
		return ResponseEntity.ok().body(profitService.inquiryPublicProfit(charityId));
	}

}