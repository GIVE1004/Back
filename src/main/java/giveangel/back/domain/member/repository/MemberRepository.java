package giveangel.back.domain.member.repository;

import giveangel.back.domain.member.entity.Member;
import giveangel.back.global.oauth.OAuthId;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

	Optional<Member> findByoAuthId(OAuthId oAuthId);

}
