package com.app.controller;

import com.app.Exception.VaccineInventoryException;
import com.app.model.Vaccine;
import com.app.model.VaccineInventory;
import com.app.service.VaccineInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app")
public class VaccineInventoryController {

    @Autowired
    VaccineInventoryService vaccineInventoryService;


   @GetMapping("/inventory")
    public ResponseEntity<List<VaccineInventory>> getAllInventory() throws VaccineInventoryException {

        return new ResponseEntity<>(vaccineInventoryService.getAllInventory(), HttpStatus.FOUND);


    }


    @GetMapping("/inventory/{centerId}")
    public ResponseEntity<VaccineInventory> getVaccineInventoryByCenter(@PathVariable int centerId) throws VaccineInventoryException {

       return new ResponseEntity<>(vaccineInventoryService.getVaccineInventoryByCenter(centerId),HttpStatus.FOUND);
    }


    @PostMapping("/inventory")
    public ResponseEntity<VaccineInventory> addInventoryCount(@RequestBody VaccineInventory vaccineInventory) throws VaccineInventoryException {

       return new ResponseEntity<>(vaccineInventoryService.addInventoryCount(vaccineInventory),HttpStatus.OK);

    }


    @PutMapping("/vaccineInventory")
    public ResponseEntity<VaccineInventory> updateVaccineInventory(VaccineInventory inventory) throws VaccineInventoryException {

        return new ResponseEntity<>(vaccineInventoryService.updateVaccineInventory(inventory),HttpStatus.CREATED);

    }


    @DeleteMapping("/deleteInventory/{id}")
    public ResponseEntity<String> deleteVaccineInventory(Integer id) throws VaccineInventoryException {

        return new ResponseEntity<>(vaccineInventoryService.deleteVaccineInventory(id),HttpStatus.FOUND);

    }

   @GetMapping("/InventoryDate/{date}")
    public ResponseEntity<VaccineInventory> getInventoryBydate(@PathVariable LocalDate date) throws VaccineInventoryException {

       return new ResponseEntity<>(vaccineInventoryService.getInventoryBydate(date),HttpStatus.FOUND);

    }


    @GetMapping("/vaccine")
    public ResponseEntity<VaccineInventory> getVaccineInventoryByVaccine(Vaccine vaccine) {

       return new ResponseEntity<>(vaccineInventoryService.getVaccineInventoryByVaccine(vaccine),HttpStatus.FOUND);


    }


}
