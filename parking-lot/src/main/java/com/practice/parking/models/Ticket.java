package com.practice.parking.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Ticket extends BaseModel {
    private Date entryDateTime;
    private Date exitDateTime;
    private Vehicle vehicle;
    private Slot allocatedSlot;
    private Gate entryGate;
    private Gate exitGate;
}
