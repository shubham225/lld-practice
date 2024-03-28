package com.practice.parking.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle extends BaseModel {
    private String plateNo;
    private VehicleType type;
    private String manufacturer;
    private String model;
}
