package com.practice.parking.services;

import com.practice.parking.exceptions.GateNotFoundException;
import com.practice.parking.models.Gate;
import com.practice.parking.repositories.GateRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GateService {

    private final GateRepository gateRepository;

    public GateService(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    public Gate getGateById(UUID gateId) {
        Optional<Gate> gateOptional = gateRepository.findById(gateId);

        if(gateOptional.isEmpty())
            throw new GateNotFoundException("Gate with id '" + gateId + "' not Found");

        return gateOptional.get();
    }
}
