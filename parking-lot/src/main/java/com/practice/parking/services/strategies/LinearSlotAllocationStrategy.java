package com.practice.parking.services.strategies;

import com.practice.parking.models.*;
import com.practice.parking.repositories.FloorRepository;
import com.practice.parking.repositories.SlotRepository;
import com.practice.parking.services.SlotAllocationStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinearSlotAllocationStrategy implements SlotAllocationStrategy {

    private final FloorRepository floorRepository;
    private final SlotRepository slotRepository;

    public LinearSlotAllocationStrategy(FloorRepository floorRepository,
                                        SlotRepository slotRepository) {
        this.floorRepository = floorRepository;
        this.slotRepository = slotRepository;
    }

    @Override
    public void allocateSlot(Ticket ticket) {
        Gate entryGate = ticket.getEntryGate();
        Building building = entryGate.getBuilding();
        Optional<List<Floor>> floorsOptional = floorRepository.findAllByBuilding(building);

        if(floorsOptional.isEmpty())
            throw new RuntimeException("Building has no floors setup");

        for(Floor floor : floorsOptional.get()) {
            Optional<List<Slot>> slotsOptional = slotRepository.findAllByFloor(floor);

            if(slotsOptional.isEmpty())
                throw new RuntimeException("Building has no floors setup");

            for(Slot slot : slotsOptional.get()) {
                if(slot.getStatus() == SlotStatus.AVAILABLE &&
                   slot.getSupportedVehicle() == ticket.getVehicle().getType()) {
                    slot.setVehicle(ticket.getVehicle());
                    slot.setStatus(SlotStatus.OCCUPIED);
                    slot = slotRepository.save(slot);

                    ticket.setAllocatedSlot(slot);
                    return;
                }
            }
        }

    }
}
