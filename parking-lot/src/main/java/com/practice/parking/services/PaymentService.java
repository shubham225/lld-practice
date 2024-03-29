package com.practice.parking.services;

import com.practice.parking.dtos.PaymentStatusResponseDto;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentStatusResponseDto getPaymentStatus(int billId) {
        // TODO : Implementation
        return new PaymentStatusResponseDto();
    }
}
