package com.app.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.MemberNotFoundException;
import com.app.exception.VaccineRegistrationException;
import com.app.exception.VaccineRegistrationNotFoundException;
import com.app.model.Member;
import com.app.model.VaccineRegistration;
import com.app.repository.MemberRepository;
import com.app.service.VaccineRegistrationService;


@RestController
public class VaccineRegistrationController {

	
	@Autowired
    private VaccineRegistrationService vaccineRegistrationService;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@PostMapping("members/{id}/registration")
	public ResponseEntity<Member> addVaccineRegistration(@PathVariable Integer id, @RequestBody VaccineRegistration vaccineRegistration) {
	    Optional<Member> optionalMember = memberRepository.findById(id);
	    if (optionalMember.isPresent()) {
	        Member member = optionalMember.get();
	        member.setRegistration(vaccineRegistration);
	        memberRepository.save(member);
	        return ResponseEntity.ok(member);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}


	@PutMapping("/members/{memberId}/registration")
	public ResponseEntity<VaccineRegistration> updateVaccineRegistration(@PathVariable Integer memberId, @RequestBody VaccineRegistration vaccineRegistration) throws MemberNotFoundException, VaccineRegistrationException {
	    try {
	        VaccineRegistration updatedRegistration = vaccineRegistrationService.updateVaccineRegistration(memberId, vaccineRegistration);
	        return ResponseEntity.status(HttpStatus.OK).body(updatedRegistration);
	    } catch (VaccineRegistrationNotFoundException e) {
	        throw new VaccineRegistrationNotFoundException(e.getMessage());
	    } catch (MemberNotFoundException e) {
	        throw new MemberNotFoundException(e.getMessage());
	    }
	}
	

	 @DeleteMapping("members/{memberId}/registration")
	 public ResponseEntity<String> deleteVaccinationRegistration(@PathVariable Integer memberId,@RequestBody VaccineRegistration reg)throws VaccineRegistrationNotFoundException, MemberNotFoundException {
	                                                                  	     	 		 
	        boolean result = vaccineRegistrationService.deleteVaccinationRegistration(memberId, reg);
	        
	        return ResponseEntity.status(HttpStatus.OK).body("Vaccination Registration deleted successfully.");
	    
	 }

	
	@GetMapping("members/registration/{mobileNo}")
    public ResponseEntity<VaccineRegistration> getVaccineRegistration(@PathVariable Long mobileNo) throws VaccineRegistrationNotFoundException {
        
		VaccineRegistration vaccineRegistration = vaccineRegistrationService.getVaccineRegistration(mobileNo);
        
		return ResponseEntity.status(HttpStatus.OK).body(vaccineRegistration);
    }


	@GetMapping("members/registrations/{mobileNo}")
	public ResponseEntity<List<Member>> getAllMemberHandler(@PathVariable Long mobileNo) throws MemberNotFoundException {
	    
		List<Member> memberList = vaccineRegistrationService.getAllMember(mobileNo);
	    
		return new ResponseEntity<>(memberList, HttpStatus.OK);
	}


	
	    
	        
	
}


