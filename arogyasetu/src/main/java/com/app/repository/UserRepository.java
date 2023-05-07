package com.app.repository;

import com.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Integer> {
    Optional<User> findByName(String username);

    @Query("SELECT u FROM User u JOIN u.aadharCardNo a WHERE a.number = :aadharNo")
    Optional<User> findByAadharNo(@Param("aadharNo") Long aadharNo);
    @Query("SELECT u FROM User u JOIN u.pancardNo a WHERE a.number = :number")
    Optional<User> getUserBypancardNo(@Param("number") String number);
}
