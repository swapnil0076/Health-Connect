package com.app.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Data
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(columnDefinition = "boolean default false")
    private boolean dose1Status = false;
    
    @Column(columnDefinition = "boolean default false")
    private boolean dose2Status = false;
    
    private LocalDate dose1Date;
    
    private LocalDate dose2Date;
    
    @Embedded
    private VaccineRegistration registration;
    
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    
    @OneToOne(mappedBy = "memberId",cascade = CascadeType.ALL)
    private Appointment appointment;
    
    @OneToOne(mappedBy = "member",cascade = CascadeType.ALL)
    private Vaccine vaccine;
}
