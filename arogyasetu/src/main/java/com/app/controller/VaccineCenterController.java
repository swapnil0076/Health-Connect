package com.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.model.VaccineCenter;
import com.app.repository.VaccineCenterRepository;
import com.app.service.VaccineCenterServiceImpl;

@RestController
@RequestMapping("/app")
@CrossOrigin("*")
public class VaccineCenterController {

    @Autowired
    private VaccineCenterServiceImpl serviceImpl;

    @Autowired
    private VaccineCenterRepository repository;

    
    
    
    @PostMapping("/vaccine-center")
    public ResponseEntity<VaccineCenter> addVaccineCenter(@RequestBody VaccineCenter center) {
        
    	VaccineCenter savedCenter = serviceImpl.addVaccineCenter(center);
        
    	return ResponseEntity.status(HttpStatus.CREATED).body(savedCenter);
    }

    
    
    @PutMapping("/vaccine-centers/{centerId}")
    public ResponseEntity<VaccineCenter> updateVaccineCenter(@PathVariable Integer centerId,
                                                             @RequestBody VaccineCenter center) {
        center.setCenterId(centerId);
        Optional<VaccineCenter> optionalCenter = serviceImpl.updateVaccineCenter(center);
        
        if (optionalCenter.isPresent()) {
            
        	return ResponseEntity.ok(optionalCenter.get());
        
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @DeleteMapping("/vaccine-centers/{centerId}")
    public ResponseEntity<Void> deleteVaccineCenter(@PathVariable Integer centerId) {
        
    	Optional<VaccineCenter> optionalCenter = repository.findById(centerId);
        
    	if (optionalCenter.isPresent()) {
    		
            VaccineCenter center = optionalCenter.get();
            serviceImpl.deleteVaccineCenter(center);
            return ResponseEntity.noContent().build();
        
    	} else {
        
    		return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/vaccine-centers/{centerId}")
    public ResponseEntity<VaccineCenter> getVaccineCenter(@PathVariable int centerId) {
        
    	VaccineCenter center = serviceImpl.getVaccineCenter(centerId);
        
    	return ResponseEntity.ok(center);
    
    }

    
    
    
    
}

