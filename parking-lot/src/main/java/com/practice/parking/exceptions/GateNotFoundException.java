package com.practice.parking.exceptions;

public class GateNotFoundException extends RuntimeException {
    public GateNotFoundException(String message) {
        super(message);
    }
}
