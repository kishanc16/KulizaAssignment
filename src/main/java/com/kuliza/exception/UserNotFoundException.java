package com.kuliza.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * It is user defined exception class
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String exception) {
		super(exception);
	}
}
