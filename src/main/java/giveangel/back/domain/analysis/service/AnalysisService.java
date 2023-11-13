package giveangel.back.domain.analysis.service;

import static giveangel.back.domain.analysis.exception.AnalysisErrorCode.NOT_EXISTS_CHARITY;

import giveangel.back.domain.analysis.entity.Analysis;
import giveangel.back.domain.analysis.exception.AnalysisException;
import giveangel.back.domain.analysis.repository.AnalysisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AnalysisService {

	private final AnalysisRepository analysisRepository;

	public String getAuditAnalysis(Long charityId) {
		Analysis analysis = analysisRepository.findByCharityId(charityId)
			.orElseThrow(() -> new AnalysisException(NOT_EXISTS_CHARITY));

		return analysis.getAudit();
	}

	public String getFinanceAnalysis(Long charityId) {
		Analysis analysis = analysisRepository.findByCharityId(charityId)
			.orElseThrow(() -> new AnalysisException(NOT_EXISTS_CHARITY));

		return analysis.getFinance();
	}

	public String getNewsAnalysis(Long charityId) {
		Analysis analysis = analysisRepository.findByCharityId(charityId)
			.orElseThrow(() -> new AnalysisException(NOT_EXISTS_CHARITY));

		return analysis.getNews();
	}
	public String getOverallAnalysis(Long charityId){
		Analysis analysis = analysisRepository.findByCharityId(charityId)
			.orElseThrow(() -> new AnalysisException(NOT_EXISTS_CHARITY));

		return analysis.getOverall();
	}
	public String getProfileAnalysis(Long charityId){
		Analysis analysis = analysisRepository.findByCharityId(charityId)
			.orElseThrow(() -> new AnalysisException(NOT_EXISTS_CHARITY));

		return analysis.getProfile();
	}

	public String getReviewAnalysis(Long charityId){
		Analysis analysis = analysisRepository.findByCharityId(charityId)
			.orElseThrow(() -> new AnalysisException(NOT_EXISTS_CHARITY));

		return analysis.getReview();
	}

	public Integer getTrustScore(Long charityId){
		Analysis analysis = analysisRepository.findByCharityId(charityId)
			.orElseThrow(() -> new AnalysisException(NOT_EXISTS_CHARITY));

		return analysis.getTrustScore();
	}

}
