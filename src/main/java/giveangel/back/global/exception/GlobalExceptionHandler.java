package giveangel.back.global.exception;

import giveangel.back.global.oauth.exception.OAuthException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(OAuthException.class)
	public ResponseEntity oauthExceptionHandler(OAuthException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	
}
