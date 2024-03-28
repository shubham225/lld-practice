package com.practice.parking.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Floor extends BaseModel {
    private String name;
    private Building building;
}
