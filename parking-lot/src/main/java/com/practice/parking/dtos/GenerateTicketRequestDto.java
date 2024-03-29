package com.practice.parking.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateTicketRequestDto {
    private int gateId;
    private String vehicleNo;
    private String vehicleType;
    private String manufacturer;
    private String model;
}
