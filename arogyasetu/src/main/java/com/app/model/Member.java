package com.app.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDate;
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
    private VaccineRegistration registration;
    @OneToOne(mappedBy = "memberId",cascade = CascadeType.ALL)
    private Appointment appointment;
    @OneToOne(mappedBy = "member",cascade = CascadeType.ALL)
    private Vaccine vaccine;


}
