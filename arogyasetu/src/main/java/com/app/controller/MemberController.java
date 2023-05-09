package com.app.controller;

import com.app.Exception.MemberException;
import com.app.Exception.MemberNotFoundException;
import com.app.model.Member;
import com.app.repository.MemberRepository;
import com.app.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/app")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("/member")
    public ResponseEntity<Member> addMemberHandler(@Valid @RequestBody Member member){

        Member member1 = memberService.addMember(member);
        return new ResponseEntity<>(member1, HttpStatus.CREATED);

    }

    @GetMapping("/memberAadhar/{aadharNo}")
    public ResponseEntity<Member> getMemberByAadharHandler(@Valid @PathVariable Long aadharNo){

       Member member =  memberService.getMemberByAdharNo(aadharNo);
        return new ResponseEntity<>(member, HttpStatus.FOUND);
    }

    @GetMapping("/memberPan/{panNo}")
    public ResponseEntity<Member> getMemberByPanHandler(@Valid @PathVariable String panNo){

        Member member =  memberService.getMemberByPanNo(panNo);
        return new ResponseEntity<>(member, HttpStatus.FOUND);
    }

    @PutMapping("/member")
    public ResponseEntity<Member> updateMemberHandler(@RequestBody Member member){

        Member member1 =  memberService.updateMember(member);
        return new ResponseEntity<>(member1, HttpStatus.FOUND);

    }

    @DeleteMapping("/member/{id}")
    public ResponseEntity<String> deleteByIdHandler(@PathVariable Integer id){

        boolean member1 =  memberService.deleteMember(id);

        if(member1){
            return new ResponseEntity<>("Member Delete with Id "+id, HttpStatus.OK);
        }else{
            throw new MemberException();
        }



    }


    @Autowired
    private MemberRepository memberRepository;


    @PostMapping("/members")
    public ResponseEntity<Member> addMember(@RequestBody Member member) {

        Optional<Member> existingMember = memberRepository.findByUserId(member.getUser().getId());

        if (existingMember.isPresent()) {

            return ResponseEntity.badRequest().build();
        }

        Member savedMember = memberService.addMember(member);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedMember);
    }



    @PutMapping("/members/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Integer id, @RequestBody Member member) {

        member.setId(id);

        Member updatedMember = memberService.updateMember(member);
        return new ResponseEntity<>(updatedMember, HttpStatus.OK);
    }



    @DeleteMapping("/members/{id}")
    public ResponseEntity<Member> deleteMember(@PathVariable("id") Integer memberId) {

        memberService.deleteMember(memberId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @GetMapping("/members/dateOfRegistration/{date}")
    public ResponseEntity<List<Member>> getMembersByDateOfRegistration(@PathVariable(value = "date") String date) throws MemberNotFoundException, MemberNotFoundException {

        LocalDate dateOfRegistration = LocalDate.parse(date);

        List<Member> members = memberService.getMembersByDateOfRegistration(dateOfRegistration);

        return ResponseEntity.ok().body(members);
    }


    @GetMapping("/members/user/{userId}")
    public ResponseEntity<List<Member>> getMembersByUser(@Valid @PathVariable Integer userId) throws MemberNotFoundException {

        List<Member> members = memberService.getMembersByUser(userId);

        if (members.isEmpty()) {
            throw new MemberNotFoundException("No members found for user with ID " + userId);
        }
        return new ResponseEntity<>(members, HttpStatus.OK);
    }



}
