package com.practice.parking.repositories;

import com.practice.parking.models.Building;
import com.practice.parking.models.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FloorRepository extends JpaRepository<Floor, UUID> {
    Optional<List<Floor>> findAllByBuilding(Building building);
}
