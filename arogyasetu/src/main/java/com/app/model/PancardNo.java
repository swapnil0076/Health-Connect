package com.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
public class PancardNo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Size(min = 10, max = 10,message = "PanCard must have 10")
    @Length(max = 10,message = "PanCard must have 10")
    private String number;
    @OneToOne(mappedBy = "pancardNo",cascade = CascadeType.ALL)
    private User userId;
}
