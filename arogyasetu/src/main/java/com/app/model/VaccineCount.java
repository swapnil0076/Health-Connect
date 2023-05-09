package com.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class VaccineCount {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vaccineId;
    private Integer quantity;
    private double price;
    @ManyToOne(cascade =  CascadeType.ALL)
    private VaccineInventory inventory_Id;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    private Vaccine vaccine_Id;

}
