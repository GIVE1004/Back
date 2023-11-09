package giveangel.back.domain.keyword.controller;


import giveangel.back.domain.keyword.service.KeywordService;
import giveangel.back.domain.keyword.service.dto.KeywordCharity;
import giveangel.back.domain.keyword.service.dto.SearchInput;
import giveangel.back.global.common.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/keyword")
@RestController
public class KeywordController {

    private final KeywordService keywordService;

    @PostMapping("/search")
    public ResponseEntity<Message<List<KeywordCharity>>> search(
            @RequestBody SearchInput input
    ){
        return ResponseEntity.ok()
                .body(Message.success(keywordService.searchCharities(input.getSearchWord())));
    }

    @GetMapping("/trending")
    public ResponseEntity<Message<List<KeywordCharity>>> trending(){
        return ResponseEntity.ok()
                .body(Message.success(keywordService.getTrendingCharities()));
    }

    @GetMapping("/interest")
    public ResponseEntity<Message<List<KeywordCharity>>> interest(){
        return ResponseEntity.ok()
                .body(Message.success(keywordService.getInterestCharities()));
    }

    @GetMapping("/activity")
    public ResponseEntity<Message<List<KeywordCharity>>> activity(){
        return ResponseEntity.ok()
                .body(Message.success(keywordService.getActivityCharities()));
    }

    @GetMapping("/match")
    public ResponseEntity<Message<List<KeywordCharity>>> match(){
        return ResponseEntity.ok()
                .body(Message.success(keywordService.getMatchCharities()));
    }

    @GetMapping("/trust")
    public ResponseEntity<Message<List<KeywordCharity>>> trust(){
        return ResponseEntity.ok()
                .body(Message.success(keywordService.getTrustCharities()));
    }
}
