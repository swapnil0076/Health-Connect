package com.app.service;

import com.app.model.Vaccine;

public interface VaccineService {

	public Vaccine addVaccine(Vaccine vaccine);

	Vaccine updateVaccine(Vaccine vaccine);

	boolean deleteVaccine(Vaccine vaccine);

	Vaccine getVaccineByName(String vaccineName);

	Vaccine getVaccineById(Integer vaccineId);	
	
	
}
