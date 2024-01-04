package com.ravi.exception;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ExceptionInfo>handleUserNotFoundException(UserNotFoundException ex){
		ExceptionInfo info = new ExceptionInfo("Ex-101",ex.getMessage(), LocalDate.now());
		return new ResponseEntity<ExceptionInfo>(info,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<String,String>> handleInavlidArgument(ConstraintViolationException ex){
		Map<String,String> errorList = new HashMap<>();
		ex.getConstraintViolations().forEach(voilation ->{
			errorList.put(""+voilation.getPropertyPath(), voilation.getMessage());
		});
		return new ResponseEntity<>(errorList,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>>handleInavlidArgument_2(MethodArgumentNotValidException ex){
		Map<String, String> errorMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->{
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
	}
	
}
