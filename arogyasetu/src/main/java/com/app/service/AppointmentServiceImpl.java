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
        return null;
    }

    @Override
    public Appointment getAppointmentById(Integer bookingId) throws AppointmentException {
        return null;
    }

    @Override
    public String addAppointment(Appointment appointment,Integer member_Id) throws AppointmentException {

       Optional<Member> member =  memberRepository.findById(member_Id);
        if(member.isPresent()){
            appointmentRepository.save(appointment);
            return "Appointment Booked";
        }else{
            throw new AppointmentException("Member not Found with this Id :"+member_Id);
        }



    }

    @Override
    public Appointment updateAppointment(Appointment appointment) throws AppointmentException {
        return null;
    }

    @Override
    public String deleteAppointment(Integer apId) throws AppointmentException {
        return null;
    }
}
