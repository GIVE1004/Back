package giveangel.back.domain.charity.repository;

import giveangel.back.domain.charity.entity.Charity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharityRepository extends JpaRepository<Charity, Long> {
}
