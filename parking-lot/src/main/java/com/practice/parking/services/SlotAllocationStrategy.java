package com.practice.parking.services;

import com.practice.parking.models.Ticket;

public interface SlotAllocationStrategy {
    public void allocateSlot(Ticket ticket);
}
