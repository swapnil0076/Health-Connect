package com.app.service;

import java.util.Optional;

import com.app.exception.CenterAlreadyExistsException;
import com.app.exception.CenterNotFoundException;
import com.app.model.VaccineCenter;

public interface VaccineCenterService {

    public VaccineCenter addVaccineCenter(VaccineCenter center) throws CenterAlreadyExistsException;

    public Optional<VaccineCenter> updateVaccineCenter(VaccineCenter center);
    
    public boolean deleteVaccineCenter(VaccineCenter center); 
	
    public VaccineCenter getVaccineCenter(int centerId)throws CenterNotFoundException;

    
}
