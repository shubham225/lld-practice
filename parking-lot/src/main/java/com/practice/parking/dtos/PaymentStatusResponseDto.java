package com.practice.parking.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentStatusResponseDto {
    private int billId;
    private String paymentId;
    private String paymentStatus;
}
