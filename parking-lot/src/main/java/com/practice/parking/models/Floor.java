package com.practice.parking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Floor extends BaseModel {
    private String name;
    @ManyToOne
    private Building building;
}
