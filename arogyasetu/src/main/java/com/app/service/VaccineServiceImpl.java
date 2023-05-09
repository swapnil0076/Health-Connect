package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.VaccineNotFoundException;
import com.app.model.Vaccine;
import com.app.repository.VaccineServiceRepository;

@Service
public class VaccineServiceImpl implements VaccineService{

	@Autowired
	private VaccineServiceRepository vaccineRepository;
	
	@Override
    public Vaccine addVaccine(Vaccine vaccine) {
		
        return vaccineRepository.save(vaccine);
    }
	
	
	@Override
    public Vaccine updateVaccine(Vaccine vaccine) {
        
		Optional<Vaccine> existingVaccine = vaccineRepository.findById(vaccine.getId());

        if (existingVaccine.isPresent()) {
        	
            return vaccineRepository.save(vaccine);
        
        } else {
        	
            throw new VaccineNotFoundException("Could not update vaccine: vaccine not found");
        }
    }
	
	
	
	@Override
    public boolean deleteVaccine(Vaccine vaccine) {
        
		Optional<Vaccine> existingVaccine = vaccineRepository.findById(vaccine.getId());

        if (existingVaccine.isPresent()) {
           
        	vaccineRepository.delete(vaccine);
            
        	return true;
        
        } else {
            
        	throw new VaccineNotFoundException("Could not delete vaccine: vaccine not found");
        }
    }
	
	
	
	  @Override
	  public Vaccine getVaccineByName(String vaccineName) {
	        
		  Optional<Vaccine> existingVaccine = vaccineRepository.findByVaccineName(vaccineName);

	        if (existingVaccine.isPresent()) {
	            
	        	return existingVaccine.get();
	        
	        } else {
	            
	        	throw new VaccineNotFoundException("Could not find vaccine with name: " + vaccineName);
	        }
	    }
	
	
	  @Override
	  public Vaccine getVaccineById(Integer vaccineId) {
	        
		  Optional<Vaccine> optionalVaccine = vaccineRepository.findById(vaccineId);
	        
		  if (optionalVaccine.isPresent()) {
	            return optionalVaccine.get();
	        
		  } else {
	            throw new VaccineNotFoundException("Could not find vaccine with id " + vaccineId);
	        }
	    }
	  
	  
	  
}
