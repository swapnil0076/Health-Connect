package com.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String vaccineName;
    private String description;

    @OneToOne(mappedBy = "vaccine_Id",cascade = CascadeType.ALL)
    private VaccineCount vaccineCount;

    @OneToOne(cascade = CascadeType.ALL)
    private Member member;

}
