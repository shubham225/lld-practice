package com.practice.parking.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateBillRequestDto {
    private int gateId;
    private int ticketId;
}
