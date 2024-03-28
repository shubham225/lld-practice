package com.practice.parking.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Building extends BaseModel {
    private String name;
    private String address;
    private Building building;
}
