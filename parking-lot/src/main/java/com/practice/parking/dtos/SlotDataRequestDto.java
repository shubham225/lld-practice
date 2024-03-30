package com.practice.parking.dtos;

import com.practice.parking.models.SlotStatus;
import com.practice.parking.models.VehicleType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SlotDataRequestDto {
    private String name;
    private VehicleType supportedVehicle;
    private UUID floorId;
}
