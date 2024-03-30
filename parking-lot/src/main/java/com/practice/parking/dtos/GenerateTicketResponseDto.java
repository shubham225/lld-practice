package com.practice.parking.dtos;

import com.practice.parking.models.Gate;
import com.practice.parking.models.Ticket;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GenerateTicketResponseDto {
    private UUID ticketId;
    private UUID gateId;
    private String vehicleNo;
    private String slot;
}
