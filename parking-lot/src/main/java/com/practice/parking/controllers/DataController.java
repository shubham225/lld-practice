package com.practice.parking.controllers;

import com.practice.parking.models.Building;
import com.practice.parking.models.Gate;
import com.practice.parking.services.DataService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/V1/data")
public class DataController {
    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/building"
    )
    public Building addBuilding(@RequestBody Building building) {
        return dataService.addBuilding(building);
    }
}
