package com.app.exception;

public class CenterNotFoundException extends RuntimeException{

	String str;
	
	public CenterNotFoundException() {
	
		
	}
	
	
	public CenterNotFoundException(String str) {
		
		super(str);
	}
	
	
	
	
}
