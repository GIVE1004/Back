package giveangel.back.domain.charity.service.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import giveangel.back.domain.charity.entity.Charity;
import giveangel.back.domain.charity.entity.Profit;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonNaming(SnakeCaseStrategy.class)
public class CharityInfo {

	private Long charityId;
	private String introduce;
	private String name;
	private String representative;
	private LocalDate establishmentDate;
	private String establishmentDateType;
	private String tel;
	private String homepage;
	private String email;
	private Integer directorCount;
	private String contributionType;
	private Integer yearlyVolunteerCount;
	private String competentAuthority;
	private Integer employeeCount;

	public static CharityInfo of(Charity charity) {
		return CharityInfo.builder()
			.charityId(charity.getId())
			.introduce(" ")
			.name(charity.getName())
			.representative(charity.getRepresentative())
			.establishmentDate(charity.getEstablishmentDate())
			.establishmentDateType(charity.getEstablishmentType())
			.tel(charity.getTel())
			.homepage(charity.getHomepage())
			.email(charity.getEmail())
			.directorCount(charity.getDirectorCount())
			.contributionType(charity.getContributionType())
			.yearlyVolunteerCount(charity.getYearlyVolunteerCount())
			.competentAuthority(charity.getCompetentAuthority())
			.employeeCount(charity.getEmployeeCount())
			.build();
	}
}
