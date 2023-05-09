package com.app.repository;

import com.app.model.Member;
import com.app.model.User;
import com.app.model.VaccineRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Integer> {


    @Query("select u from Member m inner join User u inner join AadharCardNo a where a.number = :aadharNo")
    public Optional<User> getMemberByAdharNoHandler(@Param("aadharNo") Long aadharNo);

    @Query("select u from Member m inner join User u inner join PancardNo a where a.number = :panNo")
    public Optional<User> getMemberByPanNoHandler(@Param("panNo") String panNo);


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
