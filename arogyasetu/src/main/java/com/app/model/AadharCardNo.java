package com.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Entity
public class AadharCardNo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Min(value = 12,message = "Aaddhar number must have 12 digits")
    @Max(value = 12 ,message = "Aadahar number must have 12 digits")
    private Long number;
    @OneToOne
    private User userId;

}
