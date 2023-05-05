package com.app.service;

import com.app.model.User;

public interface UserService {

    public User getUserById(Integer userId);
    public User getUserByName(String name);

}
