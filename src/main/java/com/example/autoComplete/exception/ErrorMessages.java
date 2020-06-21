package com.example.autoComplete.exception;

/**
 * @author rohitsharma
 */

public enum ErrorMessages {

	INVALID_PARAMETER_VALUE_TYPE ("Incorrect type of parameter received"),

	INTERNAL_SERVER_ERROR ("Internal server error occurred. System behaving badly.");

	private final String message;

	ErrorMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
