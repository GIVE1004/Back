package giveangel.back.domain.member.exception;

import giveangel.back.global.common.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MemberExceptionHandler {

	@ExceptionHandler(MemberException.class)
	public ResponseEntity<Message> MemberExceptionHandler(MemberException e) {
		return ResponseEntity.status(e.getErrorCode().getHttpStatus())
			.body(Message.fail(e.getErrorCode().name(), e.getMessage()));
	}
}
