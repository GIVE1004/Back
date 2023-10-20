package giveangel.back.global.oauth.vendor.naver.dto;

import static giveangel.back.global.oauth.vendor.enums.OAuthServerType.KAKAO;
import static giveangel.back.global.oauth.vendor.enums.OAuthServerType.NAVER;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import giveangel.back.domain.member.entity.Member;
import giveangel.back.domain.member.entity.MemberRole;
import giveangel.back.domain.member.entity.OAuthId;
import java.time.LocalDateTime;

@JsonNaming(SnakeCaseStrategy.class)
public record NaverMemberResponse(
	String resultcode,
	String message,
	Response response
) {

	public Member toDomain() {
		return Member.builder()
			.oAuthId(new OAuthId(String.valueOf(response.id), NAVER))
			.email(response.email)
			.nickname(response.nickname)
			.profileImageUrl(response.profileImage)
			.role(MemberRole.MEMBER)
			.build();
	}


	@JsonNaming(SnakeCaseStrategy.class)
	public record Response(
		String id,
		String nickname,
		String name,
		String email,
		String gender,
		String age,
		String birthday,
		String profileImage,
		String birthyear,
		String mobile
	) {
	}


}
