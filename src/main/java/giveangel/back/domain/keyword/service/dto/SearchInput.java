package giveangel.back.domain.keyword.service.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import static com.fasterxml.jackson.databind.PropertyNamingStrategies.*;

@Getter
@Setter
@JsonNaming(SnakeCaseStrategy.class)
public class SearchInput {
    private String searchWord;
}
