package com.app.service;

import com.app.Exception.UserException;
import com.app.model.Member;
import com.app.model.User;
import com.app.repository.AadharCardRepository;
import com.app.repository.MemberRepository;
import com.app.repository.PanCardNoRepository;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    AadharCardRepository aadharCardRepository;

    @Autowired
    PanCardNoRepository panCardNoRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public User getUserById(Integer userId) {

        return userRepository.findById(userId).get();
    }

    @Override
    public User getUserByName(String name) {

        return userRepository.findByName(name).get();
    }

    @Override
    public User getUserByPanCardNo(String number) throws UserException {

        Optional<User> user =  userRepository.getUserBypancardNo(number);
        if(user.isPresent()){
            return  user.get();
        }else {
            throw  new UserException("User not found with this : "+number);
        }
    }

    @Override
    public User getUserByAadharCardNo(Long number) throws UserException {

       Optional<User> user =  userRepository.findByAadharNo(number);

       if(user.isPresent()){
          return  user.get();
       }else {
           throw  new UserException("User not found with this : "+number);
       }


    }

    @Override
    public User addNewUser(Member member) throws UserException {
        member.getUser().setPassword(passwordEncoder.encode(member.getUser().getPassword()));
        memberRepository.save(member);

        return member.getUser();
    }

}
