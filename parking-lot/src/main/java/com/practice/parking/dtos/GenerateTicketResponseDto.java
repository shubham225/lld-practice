package com.practice.parking.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateTicketResponseDto {
    private int gateId;
    private int ticketId;
    private String vehicleNo;
    private String slot;
}
