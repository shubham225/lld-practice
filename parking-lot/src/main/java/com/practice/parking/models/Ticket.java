package com.practice.parking.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Ticket extends BaseModel {
    private LocalDateTime entryDateTime;
    private LocalDateTime exitDateTime;
    private Vehicle vehicle;
    private Slot allocatedSlot;
    private Gate entryGate;
    private Gate exitGate;
}
