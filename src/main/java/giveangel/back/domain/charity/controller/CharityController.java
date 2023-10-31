package giveangel.back.domain.charity.controller;

import giveangel.back.domain.charity.service.CharityService;
import giveangel.back.domain.charity.service.dto.CharityInfo;
import giveangel.back.global.common.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/charities/{charityId}")
@RestController
public class CharityController {

	private final CharityService charityService;

	@GetMapping
	public ResponseEntity<Message<CharityInfo>> publicCurrent(@PathVariable Long charityId) {
		return ResponseEntity.ok()
			.body(Message.success(charityService.inquiryCharity(charityId)));
	}

}
