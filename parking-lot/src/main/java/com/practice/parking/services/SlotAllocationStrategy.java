package com.practice.parking.services;

import com.practice.parking.models.Slot;
import com.practice.parking.models.Ticket;
import com.practice.parking.models.Vehicle;

public interface SlotAllocationStrategy {
    public Slot allocateSlot(Ticket ticket);
}
