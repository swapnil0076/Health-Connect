package com.app.repository;

import com.app.model.VaccineCount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Vaccine_CountRepository extends JpaRepository<VaccineCount,Integer> {
}
