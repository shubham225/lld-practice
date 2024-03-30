package com.practice.parking.repositories;

import com.practice.parking.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
    public Optional<Vehicle> findByPlateNo(String plateNo);
}
