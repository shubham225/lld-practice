package com.practice.parking.dtos;

import com.practice.parking.models.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleDto {
    private String plateNo;
    private VehicleType vehicleType;
    private String manufacturer;
    private String model;
}
