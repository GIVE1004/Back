package giveangel.back.domain.analysis.repository;

import giveangel.back.domain.analysis.entity.Analysis;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalysisRepository extends JpaRepository<Analysis, Long> {

	Optional<Analysis> findByCharityId(Long charity_id);

}
