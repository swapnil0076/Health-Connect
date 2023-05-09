package com.app.exception;

public class MemberNotFoundException extends Exception {

	
	String msg;
	
	public MemberNotFoundException() {
		
		
	}
	
	public MemberNotFoundException(String msg) {
		
		super(msg);
	}
	
	
}
