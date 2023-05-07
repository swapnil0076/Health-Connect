package com.app.repository;

import com.app.model.Appointment;
import com.app.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

}
