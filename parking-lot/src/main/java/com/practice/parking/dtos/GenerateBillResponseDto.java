package com.practice.parking.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GenerateBillResponseDto {
    private UUID ticketId;
    private UUID billId;
    private String vehicleNo;
    private int amount;
}
