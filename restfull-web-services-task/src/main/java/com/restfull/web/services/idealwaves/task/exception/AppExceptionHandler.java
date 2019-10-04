package com.restfull.web.services.idealwaves.task.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {

		String errorStatement = ex.getLocalizedMessage();
		if (errorStatement == null) {

			errorStatement = ex.toString();
		}

		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorStatement);

		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { NullPointerException.class })
	public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {

		String errorStatement = ex.getLocalizedMessage();
		if (errorStatement == null) {

			errorStatement = ex.toString();
		}

		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorStatement);

		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { ResourceNotFoundException.class })
	public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {

		String errorStatement = ex.getLocalizedMessage();
		if (errorStatement == null) {

			errorStatement = ex.toString();
		}

		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorStatement);

		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

}
