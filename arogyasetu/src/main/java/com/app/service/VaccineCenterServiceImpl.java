package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.CenterAlreadyExistsException;
import com.app.exception.CenterNotFoundException;
import com.app.model.VaccineCenter;
import com.app.repository.VaccineCenterRepository;

@Service
public class VaccineCenterServiceImpl implements VaccineCenterService{

	
	 	@Autowired
	    private VaccineCenterRepository repository;

	 	@Override
	    public VaccineCenter addVaccineCenter(VaccineCenter center) throws CenterAlreadyExistsException {
	    	
	        Optional<VaccineCenter> existingCenter = repository.findByCenterName(center.getCenterName());

	        if (existingCenter.isPresent()) {
	        	
	            throw new CenterAlreadyExistsException("Center with name " + center.getCenterName() + " already exists.");
	        }

	        return repository.save(center);
	    }

	
	 	@Override
	    public Optional<VaccineCenter> updateVaccineCenter(VaccineCenter center) {
	        
	    	Optional<VaccineCenter> optionalCenter = repository.findById(center.getCenterId());
	        
	        if (optionalCenter.isPresent()) {
	            VaccineCenter existingCenter = optionalCenter.get();
	            existingCenter.setCenterName(center.getCenterName());
	            existingCenter.setAddress(center.getAddress());
	            existingCenter.setCity(center.getCity());
	            existingCenter.setState(center.getState());
	            existingCenter.setPinCode(center.getPinCode());
	            existingCenter.setAppointmentList(center.getAppointmentList());
	            existingCenter.setInventory(center.getInventory());
	            repository.save(existingCenter);
	        }
	        
	        return optionalCenter;
	    }
	    
	    
	    
	 	@Override
	    public boolean deleteVaccineCenter(VaccineCenter center) {
	        
	    	Optional<VaccineCenter> optionalCenter = repository.findById(center.getCenterId());
	        
	    	if (optionalCenter.isPresent()) {
	            repository.delete(center);
	            return true;
	        }
	        return false;
	    }



	    @Override
	    public VaccineCenter getVaccineCenter(int centerId) throws CenterNotFoundException{
	        
	    	Optional<VaccineCenter> optionalCenter = repository.findById(centerId);
	        
	    	if (optionalCenter.isPresent()) {
	            
	    		return optionalCenter.get();
	        
	    	} else {
	            
	    		throw new CenterNotFoundException("Vaccine Center not found with id: " + centerId);
	        }
	    }
	    
	
  }
