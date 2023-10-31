package giveangel.back.domain.charity.repository;

import giveangel.back.domain.charity.entity.Expense;
import giveangel.back.domain.charity.entity.Profit;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	@Query("select e from Expense e where e.charity.id = :charityId order by e.baseYearMonth desc limit 3")
	List<Expense> findRecentThreeYearExpenseByCharityId(@Param("charityId") Long charityId);
}
