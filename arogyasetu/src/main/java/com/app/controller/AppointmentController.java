package com.app.controller;

import com.app.model.Appointment;
import com.app.model.Member;
import com.app.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/app")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/appointment")
    public ResponseEntity<String> addNewAppointHandler(@RequestBody Member appointment){

        String a = appointmentService.addAppointment(appointment);

        return new ResponseEntity<>(a, HttpStatus.CREATED);

    }
    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> getAllAppointmentHandler(){

        List<Appointment> appointments = appointmentService.allAppointments();
        return new ResponseEntity<>(appointments,HttpStatus.OK);
    }


    @GetMapping("/appointments/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Integer id){

        Appointment appointment = appointmentService.getAppointmentById(id);

        return new ResponseEntity<>(appointment,HttpStatus.OK);

    }
    @PutMapping("/appointment")
    public ResponseEntity<Appointment> UpdateAppointmentBy(@RequestBody Appointment appointment){

        Appointment appointment1 = appointmentService.updateAppointment(appointment);

        return new ResponseEntity<>(appointment1,HttpStatus.OK);

    }

    @DeleteMapping("/appointment/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Integer id){

        String appointment = appointmentService.deleteAppointment(id);

        return new ResponseEntity<>(appointment,HttpStatus.OK);

    }


}
