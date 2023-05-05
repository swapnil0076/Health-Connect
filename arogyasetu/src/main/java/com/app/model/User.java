package com.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDate dob;
    private String gender;
    private String address;
    private String password;
    @JsonIgnore
    private String role = "ROLE_USER";
    private String city;
    private String state;
    @JsonIgnore
    private String pincode;

    @JsonIgnore
    @OneToOne(mappedBy = "userId", cascade = CascadeType.ALL)
    private PancardNo pancardNo;
    @JsonIgnore
    @OneToOne(mappedBy = "userId", cascade = CascadeType.ALL)
    private AadharCardNo aadharCardNo;
    @JsonIgnore
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Member member;


}
