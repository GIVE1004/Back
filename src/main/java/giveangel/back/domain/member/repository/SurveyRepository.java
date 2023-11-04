package giveangel.back.domain.member.repository;

import giveangel.back.domain.member.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

	boolean existsByMemberId(Long memberId);
}
