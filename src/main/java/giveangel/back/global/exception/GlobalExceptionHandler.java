package giveangel.back.global.exception;

import giveangel.back.global.common.Message;
import giveangel.back.global.jwt.exception.JwtException;
import giveangel.back.global.oauth.exception.OAuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(OAuthException.class)
	public ResponseEntity<Message> oAuthExceptionHandler(OAuthException e) {
		return ResponseEntity.badRequest()
			.body(Message.fail(e.getErrorCode().name(), e.getMessage()));
	}

	@ExceptionHandler(JwtException.class)
	public ResponseEntity<Message> jwtExceptionHandler(JwtException e) {
		e.printStackTrace();
		return ResponseEntity.status(e.getErrorCode().getHttpStatus())
			.body(Message.fail(e.getErrorCode().name(), e.getMessage()));
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<Message> accessDeniedExceptionHandler(AccessDeniedException e) {
		return ResponseEntity.badRequest()
			.body(Message.fail(HttpStatus.FORBIDDEN.name(), "권한이 없습니다."));
	}

	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<Message> authenticationExceptionHandler(AuthenticationException e) {
		return ResponseEntity.badRequest()
			.body(Message.fail(HttpStatus.UNAUTHORIZED.name(), "인증되지 않은 요청입니다."));
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Message> methodArgumentTypeMismatchException(
		MethodArgumentTypeMismatchException e) {
		return ResponseEntity.badRequest()
			.body(Message.fail(HttpStatus.BAD_REQUEST.name(), "잘못된 요청입니다."));
	}
}
