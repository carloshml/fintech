package com.teste.fintech.controller.dto;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.teste.fintech.Exception.FintechException;

@RestControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(FintechException.class)
	public ProblemDetail handleFintechException(FintechException e) {
		return e.toProblemDetail();		
	}
	

}
