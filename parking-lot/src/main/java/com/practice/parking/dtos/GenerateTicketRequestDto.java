package com.practice.parking.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GenerateTicketRequestDto {
    private UUID gateId;
    private VehicleDto vehicle;
}
