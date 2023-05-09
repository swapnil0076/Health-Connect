package com.app.Exception;


public class VaccineRegistrationException extends RuntimeException {
	
	String message;
	
	public VaccineRegistrationException() {
		
				
	}
	
	
	
    public VaccineRegistrationException(String message) {
    	
        super(message);
        
        
    }
    
    
}
