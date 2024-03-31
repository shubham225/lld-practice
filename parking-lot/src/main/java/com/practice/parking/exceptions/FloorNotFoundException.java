package com.practice.parking.exceptions;

public class FloorNotFoundException extends RuntimeException {
    public FloorNotFoundException(String message) {
        super(message);
    }
}
