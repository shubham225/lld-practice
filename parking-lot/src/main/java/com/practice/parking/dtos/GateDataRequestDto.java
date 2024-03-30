package com.practice.parking.dtos;

import com.practice.parking.models.GateType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class GateDataRequestDto {
    private String name;
    private GateType type;
    private UUID buildingId;
}
