package com.practice.parking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Vehicle extends BaseModel {
    private String plateNo;

    @Enumerated(EnumType.ORDINAL)
    private VehicleType type;
    private String manufacturer;
    private String model;
}
