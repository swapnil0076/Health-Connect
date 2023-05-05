package com.app.service;

import com.app.model.User;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;


    @Override
    public User getUserById(Integer userId) {

        return userRepository.findById(userId).get();
    }

    @Override
    public User getUserByName(String name) {

        return userRepository.findByName(name).get();
    }
}
