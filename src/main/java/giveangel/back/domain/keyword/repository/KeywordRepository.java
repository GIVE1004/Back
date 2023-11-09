package giveangel.back.domain.keyword.repository;

import giveangel.back.domain.keyword.service.dto.KeywordCharity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 프론트팀 패치 작업때문에 repo 에서 더미 데이터 뿌리게 만들어 놓음
 */
@Repository
public class KeywordRepository {
    static List<KeywordCharity> dummy;

    private static void setDummyData() {
        dummy = new ArrayList<>();
        dummy.add(new KeywordCharity(
                "https://www.komysafety.com/images/banner/no-image.png",
                1L,
                "사회복지법인 사회복지공동모금회",
                "기타단체",
                "법정기부금단체",
                78,
                11502,
                -121,
                115,
                -12
        ));
        dummy.add(new KeywordCharity(
                "https://www.komysafety.com/images/banner/no-image.png",
                2L,
                "국립중앙의료원(National Medical Center)",
                "공공기관",
                "법정기부금단체",
                95,
                711520,
                12115,
                9225,
                812
        ));
        dummy.add(new KeywordCharity(
                "https://www.komysafety.com/images/banner/no-image.png",
                3L,
                "대·중소기업·농어업협력재단",
                "재단법인",
                "지정기부금단체",
                68,
                502,
                -35,
                5,
                1
        ));
        dummy.add(new KeywordCharity(
                "https://www.komysafety.com/images/banner/no-image.png",
                4L,
                "서민금융진흥원",
                "공공기관",
                "지정기부금단체",
                82,
                2502,
                -11,
                11,
                -2
        ));
        dummy.add(new KeywordCharity(
                "https://www.komysafety.com/images/banner/no-image.png",
                5L,
                "재단법인 기지",
                "재단법인",
                "지정기부금단체",
                88,
                6502,
                +121,
                215,
                -12
        ));
    }

    public List<KeywordCharity> searchCharities(String word) {
        setDummyData();
        for (KeywordCharity keywordCharity : dummy) {
            keywordCharity.setGroupName(keywordCharity.getGroupName() + word);
        }
        return dummy;
    }

    public List<KeywordCharity> getTrendingCharities() {
        setDummyData();
        for (KeywordCharity keywordCharity : dummy) {
            keywordCharity.setGroupName(keywordCharity.getGroupName() + " 지금 뜨는");
        }
        return dummy;
    }

    public List<KeywordCharity> getInterestCharities() {
        setDummyData();
        for (KeywordCharity keywordCharity : dummy) {
            keywordCharity.setGroupName(keywordCharity.getGroupName() + " 인기");
        }
        return dummy;
    }

    public List<KeywordCharity> getMatchCharities() {
        setDummyData();
        for (KeywordCharity keywordCharity : dummy) {
            keywordCharity.setGroupName(keywordCharity.getGroupName() + " 사용자 매칭");
        }
        return dummy;
    }

    public List<KeywordCharity> getTrustCharities() {
        setDummyData();
        for (KeywordCharity keywordCharity : dummy) {
            keywordCharity.setGroupName(keywordCharity.getGroupName() + " 신뢰도");
        }
        return dummy;
    }

    public List<KeywordCharity> getActivityCharities() {
        setDummyData();
        for (KeywordCharity keywordCharity : dummy) {
            keywordCharity.setGroupName(keywordCharity.getGroupName() + " 활동점수");
        }
        return dummy;
    }

    //자선단체 명 검색

    //지금 뜨는 : 오늘 조회수가 가장 많은 단체 출력

    //인기 단체 : 관심 점수가 높은 단체 출력

    //나와 맞는 단체 : 사용자 매칭 점수가 높은 단체 출력

    //높은 신뢰도 : 신뢰점수가 높은 단체 출력

    //활발한 활동 : 활동 점수가 높은 순으로 단체 출력


}
