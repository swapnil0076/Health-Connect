package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Vaccine;

@Repository
public interface VaccineServiceRepository extends JpaRepository<Vaccine, Integer>{
    
	Optional<Vaccine> findByVaccineName(String VaccineName);
}

