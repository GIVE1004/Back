package giveangel.back.domain.charity.exception;

import giveangel.back.global.common.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CharityExceptionHandler {

	@ExceptionHandler(CharityException.class)
	public ResponseEntity<Message> charityExceptionHandler(CharityException e) {
		return ResponseEntity.status(e.getErrorCode().getHttpStatus())
			.body(Message.fail(e.getErrorCode().name(), e.getMessage()));
	}
}
