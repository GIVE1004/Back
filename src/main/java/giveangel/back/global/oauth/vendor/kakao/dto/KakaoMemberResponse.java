package giveangel.back.global.oauth.vendor.kakao.dto;

import static giveangel.back.global.oauth.vendor.OAuthServerType.KAKAO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import giveangel.back.domain.member.entity.Member;
import giveangel.back.domain.member.entity.OAuthId;
import java.time.LocalDateTime;

@JsonNaming(SnakeCaseStrategy.class)
public record KakaoMemberResponse(
	Long id, // 회원 번호
	boolean hasSignedUp,
	LocalDateTime connectedAt,
	KakaoAccount kakaoAccount

) {

	public Member toDomain() {
		return Member.builder()
			.oAuthId(new OAuthId(String.valueOf(id), KAKAO))
			.nickname(kakaoAccount.profile.nickname)
			.profileImageUrl(kakaoAccount.profile.profileImageUrl)
			.build();
	}


	@JsonNaming(SnakeCaseStrategy.class)
	public record KakaoAccount(
		boolean profileNeedsAgreement,
		boolean profileNicknameNeedsAgreement,
		boolean profileImageNeedsAgreement,
		Profile profile,
		boolean nameNeedsAgreement,
		String name,
		boolean emailNeedsAgreement,
		boolean isEmailValid,
		boolean isEmailVerified,
		String email,
		boolean ageRangeNeedsAgreement,
		String ageRange,
		boolean birthyearNeedsAgreement,
		String birthyear,
		boolean birthdayNeedsAgreement,
		String birthday,
		String birthdayType,
		boolean genderNeedsAgreement,
		String gender,
		boolean phoneNumberNeedsAgreement,
		String phoneNumber,
		boolean ciNeedsAgreement,
		String ci,
		LocalDateTime ciAuthenticatedAt
	) {
	}

	@JsonNaming(SnakeCaseStrategy.class)
	public record Profile(
		String nickname,
		String thumbnailImageUrl,
		String profileImageUrl,
		boolean isDefaultImage
	) {
	}

}
