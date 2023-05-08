package com.app.service;

import com.app.Exception.MemberException;
import com.app.model.Member;
import com.app.model.User;
import com.app.repository.MemberRepository;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Member getMemberByld(Integer memberId) {

        Optional<Member> member =  memberRepository.findById(memberId);

        return member.orElseThrow(() -> new MemberException("Member not found with this memberId "+memberId));

    }

    @Override
    public Member getMemberByAdharNo(Long aadharNo) throws MemberException{

        Optional<User> member =   memberRepository.getMemberByAdharNoHandler(aadharNo);

        if (member.isPresent()) {
            Member member1 = new Member();
            member1.setUser(member.get());
            return member1;
        } else {
            throw new MemberException("Member not found with Aadhar number: " + aadharNo);
        }

    }

    @Override
    public Member getMemberByPanNo(String panNo) {
        Optional<User> member =   memberRepository.getMemberByPanNoHandler(panNo);

        if (member.isPresent()) {
            Member member1 = new Member();
            member1.setUser(member.get());
            return member1;
        } else {
            throw new MemberException("Member not found with Pan number: " + panNo);
        }
    }

    @Override
    public Member addMember(Member member) {
        member.getUser().setPassword(passwordEncoder.encode(member.getUser().getPassword()));
        memberRepository.save(member);

        return member;
    }

    @Override
    public Member updateMember(Member member) {

        Optional<Member> member1 = memberRepository.findById(member.getId());

        if(member1.isPresent()){

            memberRepository.save(member);
            return member;
        }else{
            throw  new MemberException("Member not Found with data +"+member.getId());
        }


    }

    @Override
    public boolean deleteMember(Integer memberId) {

        Optional<Member> member1 = memberRepository.findById(memberId);

        if (member1.isPresent()){
            memberRepository.delete(member1.get());


            return true;
        }else{
            throw  new MemberException("Member not Found with "+memberId);
        }


    }
}
