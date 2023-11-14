package giveangel.back.domain.member.dto;


import giveangel.back.domain.member.entity.Member;
import giveangel.back.domain.member.entity.Survey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class SurveyRequest {

	private Long memberId;
	private Integer first;
	private Integer second;
	private Integer third;
	private Integer fourth;
	private Integer five;

	public Survey toEntity() {
		return Survey.builder()
			.member(Member.builder().id(memberId).build())
			.first(first)
			.second(second)
			.third(third)
			.fourth(fourth)
			.five(five)
			.build();
	}
}
