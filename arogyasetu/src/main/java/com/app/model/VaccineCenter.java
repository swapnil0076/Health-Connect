package com.app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("inventory")
@Data
@Entity
public class VaccineCenter {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer centerId;
    private String centerName;
    private String address;
    private String city;
    private String state;
    private String pinCode;
    @OneToMany(mappedBy = "vaccineCenter",cascade = CascadeType.ALL)
    private List<Appointment> appointmentList;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private VaccineInventory inventory;

}
