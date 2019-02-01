package com.springboot.beginner.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomUniversalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException rnf, WebRequest wr) {
		
		CustomExceptionInformationBean ceib = new CustomExceptionInformationBean(new Date(), rnf.getMessage(), wr.getDescription(false));
		return new ResponseEntity<>(ceib, HttpStatus.NOT_FOUND);
		
	}

}
