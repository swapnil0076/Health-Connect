package com.app.exception;

public class VaccineInventoryException extends RuntimeException{

    public VaccineInventoryException() {
    }

    public VaccineInventoryException(String message) {
        super(message);
    }
}
