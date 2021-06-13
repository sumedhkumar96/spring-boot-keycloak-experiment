package xyz.experimental.userservice.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final HttpStatus httpStatus;
	private final String message;

	public CustomRuntimeException() {
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		this.message = super.getMessage();
	}

	public CustomRuntimeException(HttpStatus httpStatus, String message) {
		this.httpStatus = httpStatus;
		this.message = message;
	}

}
