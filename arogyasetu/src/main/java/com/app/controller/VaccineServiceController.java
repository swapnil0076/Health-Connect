package com.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.VaccineNotFoundException;
import com.app.model.Vaccine;
import com.app.repository.VaccineServiceRepository;
//import com.app.service.VaccineServiceImpl;
import com.app.service.VaccineServiceImpl;

@RestController
@RequestMapping("/vaccines")
public class VaccineServiceController {
	
	@Autowired
    private VaccineServiceImpl vaccineService;

	@Autowired
    private VaccineServiceRepository vaccineRepository;
 

    @PostMapping("/vaccines")
    public ResponseEntity<Vaccine> addVaccine(@RequestBody Vaccine vaccine) {
    	
        Vaccine addedVaccine = vaccineService.addVaccine(vaccine);

        if (addedVaccine != null) {
            return ResponseEntity.ok(addedVaccine);
        
        } else {
            throw new VaccineNotFoundException("Could not add vaccine");
        }
    }

    
    @PutMapping("/vaccines/{id}")
    public ResponseEntity<Vaccine> updateVaccine(@PathVariable("id") Integer id, @RequestBody Vaccine vaccine) {
        
    	if (!id.equals(vaccine.getId())) {
        
    		throw new IllegalArgumentException("Vaccine ID in URL path does not match vaccine ID in request body");
        }

        Vaccine updatedVaccine = vaccineService.updateVaccine(vaccine);

        if (updatedVaccine != null) {

        	return ResponseEntity.ok(updatedVaccine);
        
        } else {
            
        	throw new VaccineNotFoundException("Could not update vaccine");
        }
    }
    
    
    
    @DeleteMapping("/vaccines/{id}")
    public ResponseEntity<?> deleteVaccine(@PathVariable("id") Integer id) {
    	
        Optional<Vaccine> existingVaccine = vaccineRepository.findById(id);

        if (existingVaccine.isPresent()) {
        	
            vaccineService.deleteVaccine(existingVaccine.get());
            return ResponseEntity.noContent().build();
        
        } else {
            throw new VaccineNotFoundException("Could not delete vaccine: vaccine not found");
        }
    }
    
    
    
    @GetMapping("/vaccines/{vaccineName}")
    public ResponseEntity<Vaccine> getVaccineByName(@PathVariable("vaccineName") String vaccineName) {
        
    	Vaccine vaccine = vaccineService.getVaccineByName(vaccineName);
        
    	return ResponseEntity.ok().body(vaccine);
    }
    
    
    @GetMapping("/vaccines/{vaccineId}")
    public ResponseEntity<Vaccine> getVaccineById(@PathVariable("vaccineId") Integer vaccineId) {
        
    	Vaccine vaccine = vaccineService.getVaccineById(vaccineId);
        
    	return ResponseEntity.ok().body(vaccine);
    }
    
    
}

