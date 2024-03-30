package com.practice.parking.repositories;

import com.practice.parking.models.Floor;
import com.practice.parking.models.Slot;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SlotRepository extends JpaRepository<Slot, UUID> {
    Optional<List<Slot>> findAllByFloor(Floor floor);
}
