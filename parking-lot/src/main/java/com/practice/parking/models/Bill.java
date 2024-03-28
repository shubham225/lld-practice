package com.practice.parking.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bill extends BaseModel {
    private Ticket ticket;
    private int amount;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;
}
