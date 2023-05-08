package com.app.repository;

import com.app.model.Member;
import com.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Integer> {


    @Query("select u from Member m inner join User u inner join AadharCardNo a where a.number = :aadharNo")
    public Optional<User> getMemberByAdharNoHandler(@Param("aadharNo") Long aadharNo);

    @Query("select u from Member m inner join User u inner join PancardNo a where a.number = :panNo")
    public Optional<User> getMemberByPanNoHandler(@Param("panNo") String panNo);

}
