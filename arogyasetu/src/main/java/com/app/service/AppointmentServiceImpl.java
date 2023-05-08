package com.app.service;

import com.app.Exception.AppointmentException;
import com.app.model.Appointment;
import com.app.model.Member;
import com.app.repository.AppointmentRepository;
import com.app.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    MemberRepository memberRepository;

    @Override
    public List<Appointment> allAppointments() throws AppointmentException {

      List<Appointment> appointments =   appointmentRepository.findAll();
        if(appointments.isEmpty()){
            throw new AppointmentException("No Appointment Found");
        }else
        return appointments;
    }

    @Override
    public Appointment getAppointmentById(Integer bookingId) throws AppointmentException {

        Optional<Appointment> appointment = appointmentRepository.findById(bookingId);

        if(appointment.isPresent()){
            return appointment.get();
        }else{
            throw new AppointmentException("Appointment not Found with this : " +bookingId);
        }
    }

    @Override
    public String addAppointment(Member member1) throws AppointmentException {

       Optional<Member> member =  memberRepository.findById(member1.getId());
        if(member.isPresent()){
            member.get().setDose1Date(member1.getDose1Date());
            memberRepository.save(member1);
            return "Appointment Booked";
        }else{
            throw new AppointmentException("Member not Found with this Id :"+member1.getId());
        }



    }

    @Override
    public Appointment updateAppointment(Appointment appointment) throws AppointmentException {
        Optional<Appointment> appointment1 = appointmentRepository.findById(appointment.getBookingId());

        if(appointment1.isPresent()){
            appointment1.get();
            appointmentRepository.save(appointment);
            return appointment1.get();
        }else{
            throw new AppointmentException("Appointment not Found with this : " +appointment.getBookingId());
        }
    }

    @Override
    public String deleteAppointment(Integer apId) throws AppointmentException {
        Optional<Appointment> appointment1 = appointmentRepository.findById(apId);

        if(appointment1.isPresent()){

            appointmentRepository.delete(appointment1.get());
            return "Deleted Appointment";
        }else{
            throw new AppointmentException("Appointment not Found with this : " +apId);
        }
    }
}
