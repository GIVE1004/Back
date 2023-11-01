package giveangel.back.domain.charity.repository;

import giveangel.back.domain.charity.entity.Asset;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AssetRepository extends JpaRepository<Asset, Long> {

	@Query("select a from Asset a where a.charity.id = :charityId order by a.baseYearMonth desc limit 1")
	Optional<Asset> findRecentAssetByCharityId(@Param("charityId") Long charityId);

	@Query("select a from Asset a where a.charity.id = :charityId order by a.baseYearMonth desc limit 3")
	List<Asset> findRecentThreeYearAssetByCharityId(@Param("charityId") Long charityId);

}
