package giveangel.back.global.jwt.security;

import giveangel.back.domain.member.entity.MemberRole;
import lombok.Builder;

@Builder
public record LoginMember(
	Long id,
	String email,
	String nickname,
	String profileImageUrl,
	MemberRole role
) {

}
