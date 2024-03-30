package com.practice.parking.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class FloorDataRequestDto {
    private String name;
    private UUID buildingId;
}
