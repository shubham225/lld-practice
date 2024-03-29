package com.practice.parking.services;

import com.practice.parking.dtos.GenerateTicketRequestDto;
import com.practice.parking.dtos.GenerateTicketResponseDto;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto ticketRequestDto) {
        return new GenerateTicketResponseDto();
    }
}
