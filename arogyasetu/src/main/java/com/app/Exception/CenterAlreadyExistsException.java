package com.app.Exception;

public class CenterAlreadyExistsException extends RuntimeException {

	String str;
	
	public CenterAlreadyExistsException() {
			
	}
	

	public CenterAlreadyExistsException(String str) {
		
		super(str);
		
	}
	
	
}
