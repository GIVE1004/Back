package giveangel.back.domain.analysis.controller;

import giveangel.back.domain.analysis.service.AnalysisService;
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
public class AnalysisController {

	private final AnalysisService analysisService;

	@GetMapping("/audit/analysis")
	public ResponseEntity<Message<String>> getAuditAnalysis(@PathVariable Long charityId) {
		return ResponseEntity.ok(Message.success(analysisService.getAuditAnalysis(charityId)));
	}

	@GetMapping("/finance/analysis")
	public ResponseEntity<Message<String>> getFinanceAnalysis(@PathVariable Long charityId) {
		return ResponseEntity.ok(Message.success(analysisService.getFinanceAnalysis(charityId)));
	}

	@GetMapping("/news/analysis")
	public ResponseEntity<Message<String>> getNewsAnalysis(@PathVariable Long charityId) {
		return ResponseEntity.ok(Message.success(analysisService.getNewsAnalysis(charityId)));
	}

	@GetMapping("/overall/analysis")
	public ResponseEntity<Message<String>> getOverallAnalysis(@PathVariable Long charityId) {
		return ResponseEntity.ok(Message.success(analysisService.getOverallAnalysis(charityId)));
	}

	@GetMapping("/profile/analysis")
	public ResponseEntity<Message<String>> getProfileAnalysis(@PathVariable Long charityId) {
		return ResponseEntity.ok(Message.success(analysisService.getProfileAnalysis(charityId)));
	}

	@GetMapping("/review/analysis")
	public ResponseEntity<Message<String>> getReviewAnalysis(@PathVariable Long charityId) {
		return ResponseEntity.ok(Message.success(analysisService.getReviewAnalysis(charityId)));
	}

	@GetMapping("/trust-score")
	public ResponseEntity<Message<Integer>> getTrustScore(@PathVariable Long charityId) {
		return ResponseEntity.ok(Message.success(analysisService.getTrustScore(charityId)));
	}
}
