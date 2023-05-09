package com.app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@Entity
@Data
public class VaccineInventory {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer inventoryId;

    private LocalDate date;

   
    @OneToOne(mappedBy = "inventory",cascade = CascadeType.ALL)
    private VaccineCenter centerCode;

    @OneToMany(mappedBy = "inventory_Id",cascade = CascadeType.ALL)
    private List<VaccineCount> vaccineCount;

}
