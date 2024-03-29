package com.practice.parking.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateBillResponseDto {
    private int ticketId;
    private int billId;
    private String vehicleNo;
    private int amount;
}
