package com.practice.parking.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gate extends BaseModel {
    private String name;
    private GateType type;
}
