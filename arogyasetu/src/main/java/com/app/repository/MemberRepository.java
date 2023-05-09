package com.app.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Member;
import com.app.model.VaccineRegistration;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{

	//Member
	
    Optional<Member> findByUserId(Integer userId);
   
    List<Member> findByRegistrationDateOfRegistration(LocalDate dateOfRegistration);

    List<Member> findByUser_Id(Integer userId);
	
	
	
	//Registration
	
	Optional<Member> findByRegistration(VaccineRegistration registration);

	java.util.List<Member> findByRegistrationMobNo(Long mobileno);

//	Optional<VaccineRegistration> findByRegistration_MobNo(Integer mobNo);

    Optional<Member> findByRegistration_MobNo(Long mobileNo);

	
//	Optional<VaccineRegistration> findByRegistration_MobNo(Long mobileNo);


}
