package giveangel.back.domain.charity.exception;

import lombok.Getter;

@Getter
public class CharityException extends RuntimeException {

	private final CharityErrorCode errorCode;

	public CharityException(CharityErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}

}
