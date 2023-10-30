package giveangel.back.domain.charity.repository;

import giveangel.back.domain.charity.entity.Profit;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfitRepository extends JpaRepository<Profit, Long> {




	@Query("select p from Profit p where p.charity.id = :charityId order by p.baseYearMonth desc limit 1")
	Optional<Profit> findRecentProfitByCharityId(@Param("charityId") Long charityId);
}
