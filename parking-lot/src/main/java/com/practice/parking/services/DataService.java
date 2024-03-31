package com.practice.parking.services;

import com.practice.parking.dtos.FloorDataRequestDto;
import com.practice.parking.dtos.GateDataRequestDto;
import com.practice.parking.dtos.SlotDataRequestDto;
import com.practice.parking.exceptions.BuildingNotFoundException;
import com.practice.parking.exceptions.FloorNotFoundException;
import com.practice.parking.models.*;
import com.practice.parking.repositories.BuildingRepository;
import com.practice.parking.repositories.FloorRepository;
import com.practice.parking.repositories.GateRepository;
import com.practice.parking.repositories.SlotRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DataService {
    private final BuildingRepository buildingRepository;
    private final GateRepository gateRepository;
    private final FloorRepository floorRepository;
    private final SlotRepository slotRepository;

    public DataService(BuildingRepository buildingRepository,
                       GateRepository gateRepository,
                       FloorRepository floorRepository,
                       SlotRepository slotRepository) {
        this.buildingRepository = buildingRepository;
        this.gateRepository = gateRepository;
        this.floorRepository = floorRepository;
        this.slotRepository = slotRepository;
    }

    public Building addBuilding(Building building) {
        Building building1 = new Building();
        building1.setName(building.getName());
        building1.setAddress(building.getAddress());
        buildingRepository.save(building1);
        return building1;
    }

    public Gate addGate(GateDataRequestDto gate) {
        Gate gate1 = getGateFromDataDto(gate);
        gateRepository.save(gate1);
        return gate1;
    }

    public List<Gate> addGates(List<GateDataRequestDto> gates) {
        List<Gate> gates1 = new ArrayList<>();

        for(GateDataRequestDto gate : gates) {
            gates1.add(addGate(gate));
        }

        return gates1;
    }

    private Gate getGateFromDataDto(GateDataRequestDto gateDataRequestDto) {
        Gate gate = new Gate();
        gate.setName(gateDataRequestDto.getName());
        gate.setType(gateDataRequestDto.getType());
        UUID buildingId = gateDataRequestDto.getBuildingId();
        Optional<Building> buildingOptional = buildingRepository.findById(buildingId);

        if(buildingOptional.isEmpty())
            throw new BuildingNotFoundException("Building with id '" + buildingId + "' Not Found");

        gate.setBuilding(buildingOptional.get());

        return gate;
    }

    public Slot addSlot(SlotDataRequestDto slot) {
        Slot slot1 = getSlotFromDataDto(slot);
        slotRepository.save(slot1);
        return slot1;
    }

    public List<Slot> addSlots(List<SlotDataRequestDto> slots) {
        List<Slot> slots1 = new ArrayList<>();

        for(SlotDataRequestDto slot : slots) {
            slots1.add(addSlot(slot));
        }

        return slots1;
    }

    public Slot getSlotFromDataDto(SlotDataRequestDto slotDataDto) {
        Slot slot = new Slot();
        slot.setStatus(SlotStatus.AVAILABLE);
        slot.setVehicle(null);
        slot.setName(slotDataDto.getName());
        slot.setSupportedVehicle(slotDataDto.getSupportedVehicle());
        Optional<Floor> floorOptional = floorRepository.findById(slotDataDto.getFloorId());

        if(floorOptional.isEmpty())
            throw new FloorNotFoundException("Floor with id '" + slotDataDto.getFloorId() + "' not Found");

        slot.setFloor(floorOptional.get());

        return slot;
    }

    public Floor addFloor(FloorDataRequestDto floor) {
        Floor floor1 = getFloorFromDataDto(floor);
        floorRepository.save(floor1);
        return floor1;
    }

    public List<Floor> addFloors(List<FloorDataRequestDto> floors) {
        List<Floor> floors1 = new ArrayList<>();

        for(FloorDataRequestDto floor : floors) {
            floors1.add(addFloor(floor));
        }

        return floors1;
    }

    public Floor getFloorFromDataDto(FloorDataRequestDto floorDataDto) {
        Floor floor = new Floor();
        floor.setName(floorDataDto.getName());

        Optional<Building> buildingOptional = buildingRepository.findById(floorDataDto.getBuildingId());

        if(buildingOptional.isEmpty())
            throw new BuildingNotFoundException("Building with id '" + floorDataDto.getBuildingId() + "' Not Found");

        floor.setBuilding(buildingOptional.get());

        return floor;
    }
}
