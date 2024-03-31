package com.practice.parking.exceptions;

import com.practice.parking.services.TicketService;

public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException(String message) {
        super(message);
    }
}
