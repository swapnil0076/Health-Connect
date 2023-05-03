package com.app.model;

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
    private String city;
    private String state;
    private String pincode;

    @OneToOne(mappedBy = "userId", cascade = CascadeType.ALL)
    private PancardNo pancardNo;

    @OneToOne(mappedBy = "userId", cascade = CascadeType.ALL)
    private AadharCardNo aadharCardNo;


}
