package com.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Entity
@Data
public class Appointment {
    @Id
    private Long bookingId;
    @NotNull
    private Long mobNo;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBooking;
    @Column(columnDefinition = "boolean default false")
    private boolean bookingStatus;
    @OneToOne(cascade = CascadeType.ALL)
    private Member memberId;
    @Enumerated(EnumType.STRING)
    private Slot slots;

    @ManyToOne(cascade = CascadeType.ALL)
    private VaccineCenter vaccineCenter;

}
