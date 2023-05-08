package com.app.service;

import com.app.Exception.VaccineInventoryException;
import com.app.model.Vaccine;
import com.app.model.VaccineInventory;

import java.time.LocalDate;
import java.util.*;

public interface VaccineInventoryService {

    public List<VaccineInventory> getAllInventory() throws VaccineInventoryException;
    public VaccineInventory getVaccineInventoryByCenter(int centerId) throws VaccineInventoryException;

    public VaccineInventory addInventoryCount(VaccineInventory vaccineInventory) throws VaccineInventoryException;

   public VaccineInventory updateVaccineInventory(VaccineInventory inventory)throws VaccineInventoryException;

   public String deleteVaccineInventory(Integer id)throws VaccineInventoryException;

   public VaccineInventory getInventoryBydate(LocalDate date) throws VaccineInventoryException;

   public VaccineInventory getVaccineInventoryByVaccine(Vaccine vaccine) ;

}
