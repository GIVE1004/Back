package giveangel.back.domain.charity.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CharityErrorCode {
	NOT_EXISTS_CHARITY("존재하지 않는 기부단체 입니다.", NOT_FOUND);


	private final String message;
	private HttpStatus httpStatus;


}
