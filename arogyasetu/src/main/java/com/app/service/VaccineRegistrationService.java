package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.Exception.MemberNotFoundException;
import com.app.Exception.VaccineRegistrationNotFoundException;
import com.app.model.Member;
import com.app.model.VaccineRegistration;

public interface VaccineRegistrationService {

	
	public void addVaccineRegistration(Integer memberId, Long mobNo, LocalDate dateOfRegistration);
	
	public VaccineRegistration updateVaccineRegistration(Integer memberId, VaccineRegistration reg) throws MemberNotFoundException;
	
	public boolean deleteVaccinationRegistration(Integer memberId, VaccineRegistration reg) throws VaccineRegistrationNotFoundException, MemberNotFoundException;
	
    public VaccineRegistration getVaccineRegistration(Long mobileNo) throws VaccineRegistrationNotFoundException;

    public List<Member> getAllMember(Long mobileNo) throws MemberNotFoundException;

	
}
