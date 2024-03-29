package com.practice.parking.controllers;

import com.practice.parking.dtos.GenerateTicketRequestDto;
import com.practice.parking.dtos.GenerateTicketResponseDto;
import com.practice.parking.services.TicketService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/V1/entry")
public class EntryController {
    private final TicketService ticketService;

    public EntryController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/ticket"
    )
    public GenerateTicketResponseDto generateTicket(@RequestBody GenerateTicketRequestDto ticketRequestDto) {
        return ticketService.generateTicket(ticketRequestDto);
    }
}
