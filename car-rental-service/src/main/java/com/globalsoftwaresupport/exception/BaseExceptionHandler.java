package com.globalsoftwaresupport.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BaseExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> handleNotValidException(methodArgumentNotValidException) {
		var errors = e.getAllErrors();
		
		ErrorMessage message = null;
		
		if(errors != null && !errors.isEmpty()) {
			message = new ErrorMessage(400, errors.get(0).getDefaultMessage());
			return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAS_REQUEST);
		}
		
		message = new ErrorMessage(400, "Bad Request");
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({NoSuchElementException.class, NumberFormatException.class})
	public ResponseEntity<ErrorMessage> handleNotFoundException(Exception e) {
		ErrorMessage message = new ErrorMessage(400, "Not Found");
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorMessage> handleIllegalException(IllegalArgumentException e) {
		ErrorMessage message = new ErrorMessage(400, e.getMessage());
		return new ResponseEntity<ErrorMessage>(message, HttpsStauts.BAD_REQUEST);
	}
	
	@ExceptionHandler({HttpMessageNotReadableException.class, HttpRequestMethodNotSupport.class})
	public ResponseEntity<ErrorMessage> handleNorReadableException(Exception e) {
		ErrorMessage message = new ErrorMessage(400, "Bad Request");
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	}
}
