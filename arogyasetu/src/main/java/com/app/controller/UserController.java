package com.app.controller;

import com.app.model.User;
import com.app.service.UserService;
import jdk.jshell.spi.ExecutionControl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/app")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public ResponseEntity<User> login(Authentication auth) {

        User user = userService.getUserByName(auth.getName());

        if (user == null) {
            throw new RuntimeException("Invalid Input");
        }

        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);

    }


}
