package com.practice.parking.services;

import com.practice.parking.services.strategies.LinearSlotAllocationStrategy;
import org.springframework.stereotype.Service;

@Service
public class SlotAllocationFactory {
    private final LinearSlotAllocationStrategy linearSlotAllocationStrategy;

    public SlotAllocationFactory(LinearSlotAllocationStrategy linearSlotAllocationStrategy) {
        this.linearSlotAllocationStrategy = linearSlotAllocationStrategy;
    }
    public SlotAllocationStrategy getBestSlotAllocationStrategy() {
        // TODO : Implementation
        return linearSlotAllocationStrategy;
    }
}
