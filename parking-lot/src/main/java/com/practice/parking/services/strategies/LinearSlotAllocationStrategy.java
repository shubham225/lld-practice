package com.practice.parking.services.strategies;

import com.practice.parking.models.Slot;
import com.practice.parking.models.Ticket;
import com.practice.parking.services.SlotAllocationStrategy;
import org.springframework.stereotype.Service;

@Service
public class LinearSlotAllocationStrategy implements SlotAllocationStrategy {
    @Override
    public Slot allocateSlot(Ticket ticket) {
        // TODO : Implementation
        return null;
    }
}
