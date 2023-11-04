package giveangel.back.domain.member.controller;

import giveangel.back.domain.member.dto.SurveyRequest;
import giveangel.back.domain.member.service.SurveyService;
import giveangel.back.global.common.Message;
import giveangel.back.global.jwt.security.LoginMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/members/me/surveys")
@RestController
public class SurveyController {

	private final SurveyService surveyService;

	@PostMapping
	public ResponseEntity<Message> completeSurvey(
		@AuthenticationPrincipal LoginMember member,
		@RequestBody SurveyRequest surveyRequest
	) {
		surveyRequest.setMemberId(member.id());
		surveyService.completeSurvey(surveyRequest);

		return ResponseEntity.ok().body(Message.success());
	}

	@GetMapping("/check")
	public ResponseEntity<Message<Boolean>> checkSurvey(
		@AuthenticationPrincipal LoginMember member
	) {
		return ResponseEntity.ok().body(Message.success(surveyService.checkSurvey(member.id())));
	}
}
