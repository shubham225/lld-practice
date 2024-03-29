package com.practice.parking.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Building extends BaseModel {
    private String name;
    private String address;
}
