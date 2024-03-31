package com.practice.parking.services;

import com.practice.parking.models.Slot;
import com.practice.parking.models.SlotStatus;
import com.practice.parking.repositories.SlotRepository;
import org.springframework.stereotype.Service;

@Service
public class SlotService {

    private final SlotRepository slotRepository;

    public SlotService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    public void releaseSlot(Slot slot) {
        slot.setStatus(SlotStatus.AVAILABLE);
        slot.setVehicle(null);

        slot = slotRepository.save(slot);

    }
}
