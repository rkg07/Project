package com.example.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
//	@ExceptionHandler(TeacherIdNotFoundException.class)
//	public ResponseEntity<ErrorMessage> handleTeacherException
//	(TeacherIdNotFoundException ex, WebRequest request){
//		ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
//	}
	
	
}