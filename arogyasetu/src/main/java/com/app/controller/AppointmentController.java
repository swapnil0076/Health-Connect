package com.app.controller;

import com.app.model.Appointment;
import com.app.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/appointment/{member_Id}")
    public ResponseEntity<String> addNewAppointHandler(@RequestBody Appointment appointment, @PathVariable Integer member_Id){

        String a = appointmentService.addAppointment(appointment,member_Id);

        return new ResponseEntity<>(a, HttpStatus.CREATED);

    }


}
