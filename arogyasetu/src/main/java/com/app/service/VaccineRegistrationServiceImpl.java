package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Exception.MemberNotFoundException;
import com.app.Exception.VaccineRegistrationException;
import com.app.Exception.VaccineRegistrationNotFoundException;
import com.app.model.Member;
import com.app.model.VaccineRegistration;
import com.app.repository.MemberRepository;

@Service
public class VaccineRegistrationServiceImpl implements VaccineRegistrationService {

    
    @Autowired
    private MemberRepository memberRepository;
    
    @Override
    public void addVaccineRegistration(Integer memberId, Long mobNo, LocalDate dateOfRegistration) {
        
    	Member member = memberRepository.findById(memberId).orElseThrow(() -> new VaccineRegistrationException("Invalid member ID"));
        VaccineRegistration vaccineRegistration = new VaccineRegistration();
        vaccineRegistration.setMobNo(mobNo);
        vaccineRegistration.setDateOfRegistration(dateOfRegistration);
        member.setRegistration(vaccineRegistration);
        memberRepository.save(member);
    }
	 
	    
    
   
    @Override
    public VaccineRegistration updateVaccineRegistration(Integer memberId, VaccineRegistration reg) throws MemberNotFoundException, VaccineRegistrationException {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            if (reg == null) {
                throw new VaccineRegistrationException("Vaccine registration cannot be null");
            } else if (member.getRegistration() == null) {
                throw new VaccineRegistrationNotFoundException("Vaccine registration is Empty " + memberId);
            } else {
                member.setRegistration(reg);
                memberRepository.save(member);
                return reg;
            }
        } else {
            throw new MemberNotFoundException("Member not found with id " + memberId);
        }
    }
   
    
    @Override
    public boolean deleteVaccinationRegistration(Integer memberId, VaccineRegistration reg) throws VaccineRegistrationNotFoundException, MemberNotFoundException {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException("Member not found with id " + memberId));

        if (member.getRegistration() == null || !member.getRegistration().equals(reg)) {
            throw new VaccineRegistrationNotFoundException("Vaccine Registration not found for member with id " + memberId);
        }

        member.setRegistration(null);
        memberRepository.save(member);

        return true;
    }
    

    

    @Override
    public VaccineRegistration getVaccineRegistration(Long mobileNo) throws VaccineRegistrationNotFoundException {
        Optional<Member> optionalMember = memberRepository.findByRegistration_MobNo(mobileNo);
        if (optionalMember.isPresent()) {
        
            return optionalMember.get().getRegistration();
        } else {
            throw new VaccineRegistrationNotFoundException("Vaccine registration not found for mobile number " + mobileNo);
        }
    }


    
    
    
    @Override
    public List<Member> getAllMember(Long mobileno) throws MemberNotFoundException {
    	
        List<Member> memberList = memberRepository.findByRegistrationMobNo(mobileno);
        return Optional.ofNullable(memberList)
                .orElseThrow(() -> new MemberNotFoundException("No members found for mobile number: " + mobileno));
    }
    
    
    
    
    
    

}

