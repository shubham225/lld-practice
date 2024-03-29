package com.practice.parking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel {
    private Date entryDateTime;
    private Date exitDateTime;
    @OneToOne
    private Vehicle vehicle;
    @OneToOne
    private Slot allocatedSlot;
    @OneToOne
    private Gate entryGate;
    @OneToOne
    private Gate exitGate;
}
