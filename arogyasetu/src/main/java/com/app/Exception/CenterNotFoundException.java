package com.app.Exception;

public class CenterNotFoundException extends RuntimeException{

	String str;
	
	public CenterNotFoundException() {
	
		
	}
	
	
	public CenterNotFoundException(String str) {
		
		super(str);
	}
	
	
	
	
}
