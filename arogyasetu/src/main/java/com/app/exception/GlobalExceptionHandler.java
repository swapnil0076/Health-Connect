package com.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	
	
	@ExceptionHandler(VaccineNotFoundException.class)
	public ResponseEntity<MyErrorDetails> expHandler(VaccineNotFoundException ex, WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ex.getMessage());
		err.setDetails(req.getDescription(false));
		
					
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
	
	@ExceptionHandler(VaccineInventoryException.class)
	public ResponseEntity<MyErrorDetails> expHandler(VaccineInventoryException ex, WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ex.getMessage());
		err.setDetails(req.getDescription(false));
		
					
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	@ExceptionHandler(MemberNotFoundException.class)
	public ResponseEntity<MyErrorDetails> expHandler(MemberNotFoundException ex, WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ex.getMessage());
		err.setDetails(req.getDescription(false));
		
					
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
	@ExceptionHandler(CenterNotFoundException.class)
	public ResponseEntity<MyErrorDetails> expHandler(CenterNotFoundException ex, WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ex.getMessage());
		err.setDetails(req.getDescription(false));
		
					
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
	//application sepcific exception
		@ExceptionHandler(VaccineRegistrationException.class)
		public ResponseEntity<MyErrorDetails> expHandler(VaccineRegistrationException ex, WebRequest req){
			
			MyErrorDetails err = new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(ex.getMessage());
			err.setDetails(req.getDescription(false));
			
						
			return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
			
		}
		
	
		@ExceptionHandler(CenterAlreadyExistsException.class)
		public ResponseEntity<MyErrorDetails> expHandler(CenterAlreadyExistsException ex, WebRequest req){
			
			MyErrorDetails err = new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(ex.getMessage());
			err.setDetails(req.getDescription(false));
			
						
			return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
			
		}
		
	
		
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception se, WebRequest req){
		
		
		MyErrorDetails err= new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(se.getMessage());
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	
	
	@ExceptionHandler(VaccineRegistrationNotFoundException.class)
	public ResponseEntity<MyErrorDetails> handleVaccineRegistrationNotFoundException(VaccineRegistrationNotFoundException ex, WebRequest req){
	    MyErrorDetails err = new MyErrorDetails();
	    err.setTimestamp(LocalDateTime.now());
	    err.setMessage(ex.getMessage());
	    err.setDetails(req.getDescription(false));
	    
	    return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}

	
	
//	
//	@ExceptionHandler(NoHandlerFoundException.class)
//	public ResponseEntity<MyErrorDetails> expHandler3(NoHandlerFoundException ex, WebRequest req){
//		
//		MyErrorDetails err = new MyErrorDetails();
//		err.setTimestamp(LocalDateTime.now());
//		err.setMessage(ex.getMessage());
//		err.setDetails(req.getDescription(false));
//		
//		
//		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
//		
//	}
	
	
	
	
	
	
	
}
