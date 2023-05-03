package com.app.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Embeddable
@Data
public class VaccineRegistration {
    private Long mobNo;
    private LocalDate dateOfRegistration;

}
