package com.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String role = "ROLE_USER";
    private String city;
    private String state;
    private String pincode;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne( cascade = CascadeType.ALL)
    private PancardNo pancardNo;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne( cascade = CascadeType.ALL)
    private AadharCardNo aadharCardNo;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Member member;


}
