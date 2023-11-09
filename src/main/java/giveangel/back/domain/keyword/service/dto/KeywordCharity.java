package giveangel.back.domain.keyword.service.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KeywordCharity {
    private String source; //기부단체 이미지 주소
    private Long groupId; //기부단체 ID
    private String groupName; //기부단체 명
    private String groupTag; //기부단체 대분류
    private String groupLabel; //기부단체 소분류
    private Integer groupScore; //기부단체의 평균 평점
    private Integer groupNumber; //기부단체의 총 기부자 수
    private Integer groupNumberPm; //기부단체 기부자 수 전일 대비 증감
    private Integer groupStar; //기부단체의 총 관심등록 수
    private Integer groupStarPm; //기부단체의 관심등록 수 전일 대비 증감
}

