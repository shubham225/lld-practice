package com.practice.parking.controllers;

import com.practice.parking.dtos.PaymentStatusResponseDto;
import com.practice.parking.services.PaymentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/V1/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{billId}"
    )
    public PaymentStatusResponseDto generateTicket(@RequestParam int billId) {
        return paymentService.getPaymentStatus(billId);
    }
}
