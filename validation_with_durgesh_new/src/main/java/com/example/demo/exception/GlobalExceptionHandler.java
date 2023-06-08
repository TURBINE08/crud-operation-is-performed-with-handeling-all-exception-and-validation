package com.example.demo.exception;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.example.demo.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler 
{ 
	
	 
	
	@ExceptionHandler( ResourceNotFoundExceptions.class)
	public ResponseEntity<ApiResponse> resourseNotFoundExceptionHandler(ResourceNotFoundExceptions ex)
	{
		String umessage = "user not found";
		String message = ex.getMessage();
		ApiResponse apiresponse = new ApiResponse(umessage,message,false);
		return new ResponseEntity<ApiResponse>(apiresponse,HttpStatus.NOT_FOUND);
	} 
	
	
	

	@ExceptionHandler( ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourseNotFoundExceptionHandler(ResourceNotFoundException ex)
	{
		String umessage = "user not found";
		String message = ex.getMessage();
		ApiResponse apiresponse = new ApiResponse(umessage,message,false);
		return new ResponseEntity<ApiResponse>(apiresponse,HttpStatus.NOT_FOUND);
	}  
	
	
	@ExceptionHandler( MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ApiResponse> MethodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException ex) 
	{
		String message = ex.getMessage();
		String umessage = "enter only number value ";
		ApiResponse apiresponse = new ApiResponse(umessage,message, false);
		return new ResponseEntity<ApiResponse>(apiresponse,HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler( MethodArgumentNotValidException.class) 
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex)
	{
		Map<String, String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) ->{
		String fieldName =((FieldError)error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName,message);
		} );
		return new ResponseEntity<Map<String, String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	


	 
	
	
	
}
