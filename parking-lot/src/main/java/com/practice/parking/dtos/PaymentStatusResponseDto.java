package com.practice.parking.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PaymentStatusResponseDto {
    private UUID billId;
    private UUID paymentId;
    private String paymentStatus;
}
