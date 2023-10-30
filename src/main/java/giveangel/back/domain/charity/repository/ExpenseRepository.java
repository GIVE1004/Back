package giveangel.back.domain.charity.repository;

import giveangel.back.domain.charity.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
