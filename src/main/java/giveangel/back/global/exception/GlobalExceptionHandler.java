package giveangel.back.global.exception;

import giveangel.back.global.common.Message;
import giveangel.back.global.jwt.exception.JwtException;
import giveangel.back.global.oauth.exception.OAuthException;
import io.jsonwebtoken.Jwt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(OAuthException.class)
	public ResponseEntity<Message> oAuthExceptionHandler(OAuthException e) {
		return ResponseEntity.badRequest()
			.body(Message.fail(e.getErrorCode().name(), e.getMessage()));
	}
	@ExceptionHandler(JwtException.class)
	public ResponseEntity<Message> jwtExceptionHandler(JwtException e) {
		return ResponseEntity.badRequest()
			.body(Message.fail(e.getErrorCode().name(), e.getMessage()));
	}

}
