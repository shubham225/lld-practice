package com.practice.parking.services.strategies;

import com.practice.parking.exceptions.FloorNotFoundException;
import com.practice.parking.exceptions.SlotNotFoundException;
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
            throw new FloorNotFoundException("No parking floors found in Building - " + building.getName());

        for(Floor floor : floorsOptional.get()) {
            Optional<List<Slot>> slotsOptional = slotRepository.findAllByFloor(floor);

            if(slotsOptional.isEmpty())
                throw new SlotNotFoundException("No Slots found on Floor - " + floor.getName());

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
