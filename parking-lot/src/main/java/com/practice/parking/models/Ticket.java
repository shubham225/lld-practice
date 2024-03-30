package com.practice.parking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    private Vehicle vehicle;
    @ManyToOne
    private Slot allocatedSlot;
    @ManyToOne
    private Gate entryGate;
    @ManyToOne
    private Gate exitGate;
}
