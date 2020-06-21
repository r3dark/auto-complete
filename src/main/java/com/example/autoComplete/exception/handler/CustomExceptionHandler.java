package com.example.autoComplete.exception.handler;

import com.example.autoComplete.exception.ErrorMessages;
import com.example.autoComplete.model.response.ErrorResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * @author rohitsharma
 */

@ControllerAdvice
public class CustomExceptionHandler {

	@Autowired
	ErrorResponse errorResponse;

	private static final Logger log = LogManager.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler (MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorResponse> handleInvalidParamValueException(MethodArgumentTypeMismatchException ex) {

		errorResponse.setErrorMessage(ErrorMessages.INVALID_PARAMETER_VALUE_TYPE.getMessage() + " : " + ex.getName());
		log.error("Invalid type of parameter received in request : " + ex.getName(), ex);

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler (Exception.class)
	public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {

		errorResponse.setErrorMessage(ErrorMessages.INTERNAL_SERVER_ERROR.getMessage());
		log.error("Internal server error occurred: " + ex.getMessage(), ex);

		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
