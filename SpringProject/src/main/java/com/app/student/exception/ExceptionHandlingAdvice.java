package com.app.student.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


//We are applying to all our controllers that we have so it is said to be
//controller Advice
@ControllerAdvice
public class ExceptionHandlingAdvice {
	
	//Advice wraps your method..
	
	@ExceptionHandler(MethodArgumentNotValidException.class)//Now, Spring will no we are handling this exception
	public @ResponseBody  ResponseEntity<List<String>  >handleMethodArgumentNotValidException(MethodArgumentNotValidException me) {
		
		//@ResponseBody will convert the objects to JSON Objects.
		//Where as in Controllers we didn't write as @ResponseBody we specified controllers class with @RestController so spring already knows that
		List<ObjectError>errors = me.getBindingResult().getAllErrors();
		 List<String>messages = new ArrayList<>();
		for (ObjectError objectError : errors) {
			
			 messages.add(objectError.getDefaultMessage());
		}
		return new ResponseEntity<List<String>>(messages,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)//Now, Spring will no we are handling this exception
	public @ResponseBody  ResponseEntity<List<String>>handleException(Exception e) {
		
		//@ResponseBody will convert the objects to JSON Objects.
		//Where as in Controllers we didn't write as @ResponseBody we specified controllers class with @RestController so spring already knows that
		List<String>messages = new ArrayList<>();
		messages.add(e.getMessage());
		return new ResponseEntity<List<String>>(messages,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	@ExceptionHandler(NotFoundException.class)//Now, Spring will no we are handling this exception
	public @ResponseBody  ResponseEntity<List<String>>handleException(NotFoundException e) {
		
		//@ResponseBody will convert the objects to JSON Objects.
		//Where as in Controllers we didn't write as @ResponseBody we specified controllers class with @RestController so spring already knows that
		List<String>messages = new ArrayList<>();
		messages.add(e.getMessage());
		return new ResponseEntity<List<String>>(messages,HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
	
	
	
	
	
}
