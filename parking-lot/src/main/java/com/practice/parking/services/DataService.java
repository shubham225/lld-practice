package com.practice.parking.services;

import com.practice.parking.models.Building;
import com.practice.parking.repositories.BuildingRepository;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    private final BuildingRepository buildingRepository;

    public DataService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public Building addBuilding(Building building) {
        Building building1 = new Building();
        building1.setName(building.getName());
        building1.setAddress(building.getAddress());
        buildingRepository.save(building1);
        return building1;
    }
}
