package com.practice.parking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Gate extends BaseModel {
    private String name;

    @Enumerated(EnumType.ORDINAL)
    private GateType type;

    @ManyToOne
    private Building building;
}
