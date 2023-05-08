package com.app.controller;

import com.app.Exception.MemberException;
import com.app.model.Member;
import com.app.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
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


}
