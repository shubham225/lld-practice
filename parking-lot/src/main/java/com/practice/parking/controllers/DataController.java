package com.practice.parking.controllers;

import com.practice.parking.dtos.FloorDataRequestDto;
import com.practice.parking.dtos.GateDataRequestDto;
import com.practice.parking.dtos.SlotDataRequestDto;
import com.practice.parking.models.Building;
import com.practice.parking.models.Floor;
import com.practice.parking.models.Gate;
import com.practice.parking.models.Slot;
import com.practice.parking.services.DataService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/V1/data")
public class DataController {
    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/building"
    )
    public Building addBuilding(@RequestBody Building building) {
        return dataService.addBuilding(building);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/gate"
    )
    public Gate addGate(@RequestBody GateDataRequestDto gate) {
        return dataService.addGate(gate);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/gates"
    )
    public List<Gate> addGates(@RequestBody List<GateDataRequestDto> gates) {
        return dataService.addGates(gates);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/floor"
    )
    public Floor addFloor(@RequestBody FloorDataRequestDto floor) {
        return dataService.addFloor(floor);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/floors"
    )
    public List<Floor> addFloors(@RequestBody List<FloorDataRequestDto> floors) {
        return dataService.addFloors(floors);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/slot"
    )
    public Slot addSlot(@RequestBody SlotDataRequestDto slot) {
        return dataService.addSlot(slot);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/slots"
    )
    public List<Slot> addSlots(@RequestBody List<SlotDataRequestDto> slots) {
        return dataService.addSlots(slots);
    }
}
