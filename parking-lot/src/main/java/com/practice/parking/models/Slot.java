package com.practice.parking.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Slot extends BaseModel {
    private String name;
    @Enumerated(EnumType.ORDINAL)
    private VehicleType supportedVehicle;
    @Enumerated(EnumType.ORDINAL)
    private SlotStatus status;

    @ManyToOne
    private Floor floor;
    @OneToOne
    private Vehicle vehicle;
}
