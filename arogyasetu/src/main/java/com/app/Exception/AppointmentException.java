package com.app.Exception;

public class AppointmentException extends RuntimeException{

    public AppointmentException() {
    }

    public AppointmentException(String message) {
        super(message);
    }
}
