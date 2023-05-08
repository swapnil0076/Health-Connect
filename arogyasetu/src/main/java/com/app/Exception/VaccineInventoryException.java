package com.app.Exception;

public class VaccineInventoryException extends RuntimeException{

    public VaccineInventoryException() {
    }

    public VaccineInventoryException(String message) {
        super(message);
    }
}
