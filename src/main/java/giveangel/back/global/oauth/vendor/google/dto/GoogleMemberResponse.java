package giveangel.back.global.oauth.vendor.google.dto;

import static giveangel.back.global.oauth.vendor.enums.OAuthServerType.KAKAO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import giveangel.back.domain.member.entity.Member;
import giveangel.back.domain.member.entity.MemberRole;
import giveangel.back.domain.member.entity.OAuthId;
import giveangel.back.global.oauth.vendor.kakao.dto.KakaoMemberResponse.KakaoAccount;
import java.time.LocalDateTime;

@JsonNaming(SnakeCaseStrategy.class)
public record GoogleMemberResponse(
	String familyName,
	String name,
	String picture,
	String locale,
	String email,
	String givenName,
	String id,
	boolean verifiedEmail
) {

	public Member toDomain() {
		return Member.builder()
			.oAuthId(new OAuthId(String.valueOf(id), KAKAO))
			.email(email)
			.nickname(name)
			.profileImageUrl(picture)
			.role(MemberRole.MEMBER)
			.build();
	}

}
