package com.app.service;

import com.app.Exception.AppointmentException;
import com.app.model.Appointment;
import com.app.model.Member;

import java.util.*;

public interface AppointmentService {

    public List<Appointment> allAppointments()throws AppointmentException;
    public Appointment getAppointmentById(Integer bookingId) throws AppointmentException;

    public String addAppointment(Member member) throws AppointmentException;

    public Appointment updateAppointment(Appointment appointment) throws AppointmentException;

    public String deleteAppointment(Integer apId) throws AppointmentException;

}
