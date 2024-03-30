package com.practice.parking.repositories;

import com.practice.parking.models.Gate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GateRepository extends JpaRepository<Gate, UUID> {

}
