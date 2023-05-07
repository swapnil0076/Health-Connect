package com.app.service;

import com.app.Exception.UserException;
import com.app.model.Member;
import com.app.model.User;

public interface UserService {

    public User getUserById(Integer userId);
    public User getUserByName(String name);

    public User getUserByPanCardNo(String number) throws UserException;

    public User getUserByAadharCardNo(Long number) throws UserException;

    public User addNewUser(Member member) throws UserException;

}
