package giveangel.back.domain.member.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberErrorCode {
	ALREADY_COMPLETED_SURVEY("이미 설문 조사를 완료하였습니다.", BAD_REQUEST);

	private final String message;
	private HttpStatus httpStatus;


}
