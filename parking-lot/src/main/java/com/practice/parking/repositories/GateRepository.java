package com.practice.parking.repositories;

import com.practice.parking.models.Gate;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GateRepository extends JpaRepository<Gate, UUID> {
    public Optional<Gate> findById(UUID gateId);
}
