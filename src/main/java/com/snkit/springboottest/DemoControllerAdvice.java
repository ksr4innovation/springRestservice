package com.snkit.springboottest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DemoControllerAdvice {
	
@ExceptionHandler(TestException.class)
public ResponseEntity demoExceptionMultiValue(TestException exception)
{
	
	MultiValueMap<String,String> map = new LinkedMultiValueMap<String,String>();
	
	map.add("id",exception.getId());
	map.add("message",exception.getMessage());
	return new ResponseEntity(map,HttpStatus.OK);
	
}
@ExceptionHandler(DemoException.class)
public ResponseEntity<ErrorResponse> demoException(DemoException exception)
{
	
	ErrorResponse resp = new ErrorResponse();
	
	resp.setId(exception.getId());
	resp.setMessage(exception.getMessage());
	return new ResponseEntity<ErrorResponse>(resp,HttpStatus.OK);
	
}

}
