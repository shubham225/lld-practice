package com.practice.parking.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GenerateBillRequestDto {
    private UUID gateId;
    private UUID ticketId;
}
