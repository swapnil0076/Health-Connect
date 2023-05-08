package com.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Entity
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer bookingId;

    private Long mobNo;
    @FutureOrPresent
//    @DateTimeFormat(pattern = "dd-MM-yyyy")
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
