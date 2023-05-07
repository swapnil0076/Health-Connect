package com.app.controller;

import com.app.model.Member;
import com.app.model.User;
import com.app.service.UserService;
import jakarta.validation.Valid;
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

    @PostMapping("/user")
    public ResponseEntity<User> addNewUserHandler(@Valid @RequestBody Member member){

        User user1 = userService.addNewUser(member);

        return new ResponseEntity<>(user1,HttpStatus.CREATED);

    }

    @GetMapping("/user/{aadharCardNo}")
    public ResponseEntity<User> getUserByAadharCardNoHandler(@PathVariable Long aadharCardNo){

        User user =  userService.getUserByAadharCardNo(aadharCardNo);

        return new ResponseEntity<>(user,HttpStatus.FOUND);
    }

    @GetMapping("/userPan/{panCardNo}")
    public ResponseEntity<User> getUserByPanCardNoHandler(@PathVariable String panCardNo){

        User user =  userService.getUserByPanCardNo(panCardNo);

        return new ResponseEntity<>(user,HttpStatus.FOUND);
    }

}
