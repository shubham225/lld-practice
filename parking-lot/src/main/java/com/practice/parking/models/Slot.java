package com.practice.parking.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Slot extends BaseModel {
    private VehicleType supportedVehicle;
    private SlotStatus status;
    private Floor floor;
    private Vehicle vehicle;
}
