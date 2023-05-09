package com.app.repository;

import com.app.model.VaccineInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface VaccineInventoryRepository extends JpaRepository<VaccineInventory,Integer> {
    Optional<VaccineInventory> findByDate(LocalDate date);
}
