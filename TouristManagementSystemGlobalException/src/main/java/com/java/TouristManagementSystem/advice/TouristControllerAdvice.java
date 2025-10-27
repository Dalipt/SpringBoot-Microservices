package com.java.TouristManagementSystem.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.java.TouristManagementSystem.exception.TouristNotFoundException;

@RestControllerAdvice
public class TouristControllerAdvice 
{
	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails>handleTouristException(TouristNotFoundException tnfe)
	{
		ErrorDetails error=new ErrorDetails("404 Not Found",tnfe.getMessage(),LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails>Exception(Exception fe)
	{
		ErrorDetails error=new ErrorDetails("Internal Server Error",fe.getMessage(),LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
