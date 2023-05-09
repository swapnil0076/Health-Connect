package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.VaccineCenter;

@Repository
public interface VaccineCenterRepository extends JpaRepository<VaccineCenter, Integer>{

	Optional<VaccineCenter> findByCenterName(String centerName);
	
	Optional<VaccineCenter> findById(Integer centerId);

	

}
