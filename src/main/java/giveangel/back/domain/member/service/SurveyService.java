package giveangel.back.domain.member.service;

import static giveangel.back.domain.member.exception.MemberErrorCode.ALREADY_COMPLETED_SURVEY;

import giveangel.back.domain.member.dto.SurveyRequest;
import giveangel.back.domain.member.entity.Survey;
import giveangel.back.domain.member.exception.MemberException;
import giveangel.back.domain.member.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class SurveyService {

	private final SurveyRepository surveyRepository;

	public void completeSurvey(SurveyRequest request) {

		if (surveyRepository.existsByMemberId(request.getMemberId())) {
			throw new MemberException(ALREADY_COMPLETED_SURVEY);
		}

		surveyRepository.save(request.toEntity());
	}

	public boolean checkSurvey(Long memberId) {
		return surveyRepository.existsByMemberId(memberId);
	}

}
