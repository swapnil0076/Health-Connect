package com.app.service;

import com.app.Exception.VaccineInventoryException;
import com.app.model.Vaccine;
import com.app.model.VaccineCenter;
import com.app.model.VaccineInventory;
import com.app.repository.VaccineCenterRepository;
import com.app.repository.VaccineInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VaccineInventoryServiceImpl implements VaccineInventoryService{

    @Autowired
    VaccineCenterRepository centerRepository;

    @Autowired
    VaccineInventoryRepository inventoryRepository;

    @Override
    public List<VaccineInventory> getAllInventory() throws VaccineInventoryException {

        List<VaccineInventory> vaccineInventories = inventoryRepository.findAll();

        if(vaccineInventories.isEmpty()){
            throw  new VaccineInventoryException();
        }else{
            return vaccineInventories;
        }


    }

    @Override
    public VaccineInventory getVaccineInventoryByCenter(int centerId) throws VaccineInventoryException {




        return null;
    }

    @Override
    public VaccineInventory addInventoryCount(VaccineInventory vaccineInventory,Integer centerId) throws VaccineInventoryException {

        Optional<VaccineCenter> center =  centerRepository.findById(centerId);

        if(center.isPresent()){
            inventoryRepository.save(vaccineInventory);
            return vaccineInventory;
        }else{
            throw new VaccineInventoryException();
        }




    }

    @Override
    public VaccineInventory updateVaccineInventory(VaccineInventory inventory) throws VaccineInventoryException {

      Optional<VaccineInventory> vaccineInventory =  inventoryRepository.findById(inventory.getInventoryId());

      if(vaccineInventory.isPresent()){

          inventoryRepository.save(inventory);

          return inventory;

      }else{
        throw new VaccineInventoryException();
      }


    }

    @Override
    public String deleteVaccineInventory(Integer id) throws VaccineInventoryException {
        Optional<VaccineInventory> vaccineInventory =  inventoryRepository.findById(id);

        if(vaccineInventory.isPresent()){
            inventoryRepository.delete(vaccineInventory.get());
            return "done...";
        }else{
            throw new VaccineInventoryException();
        }



    }

    @Override
    public VaccineInventory getInventoryBydate(LocalDate date) throws VaccineInventoryException {

      Optional<VaccineInventory> inventory =   inventoryRepository.findByDate(date);

      if(inventory.isPresent()){

          return inventory.get();

      }else{
          throw new VaccineInventoryException();
      }


    }

    @Override
    public VaccineInventory getVaccineInventoryByVaccine(Vaccine vaccine) {
        return null;
    }
}
