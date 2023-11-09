package giveangel.back.domain.keyword.service;


import giveangel.back.domain.keyword.repository.KeywordRepository;
import giveangel.back.domain.keyword.service.dto.KeywordCharity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KeywordService {

    private final KeywordRepository keywordRepository;

    //자선단체 명 검색
    public List<KeywordCharity> searchCharities(String word){
        return keywordRepository.searchCharities(word);
    }

    //지금 뜨는 : 오늘 조회수가 가장 많은 단체 출력
    public List<KeywordCharity> getTrendingCharities(){
        return keywordRepository.getTrendingCharities();
    }

    //인기 단체 : 관심 점수가 높은 단체 출력
    public List<KeywordCharity> getInterestCharities(){
        return keywordRepository.getInterestCharities();
    }

    //나와 맞는 단체 : 사용자 매칭 점수가 높은 단체 출력
    public List<KeywordCharity> getMatchCharities(){
        return keywordRepository.getMatchCharities();
    }

    //높은 신뢰도 : 신뢰점수가 높은 단체 출력
    public List<KeywordCharity> getTrustCharities(){
        return keywordRepository.getTrustCharities();
    }

    //활발한 활동 : 활동 점수가 높은 순으로 단체 출력
    public List<KeywordCharity> getActivityCharities(){
        return keywordRepository.getActivityCharities();
    }
}
