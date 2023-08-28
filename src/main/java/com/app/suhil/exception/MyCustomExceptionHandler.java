package com.app.suhil.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyCustomExceptionHandler 
{

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<String> showStudentNotFoundError(StudentNotFoundException snfe) 
	{
		return new ResponseEntity<>(
				snfe.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}