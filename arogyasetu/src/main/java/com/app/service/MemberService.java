package com.app.service;

import com.app.Exception.MemberException;
import com.app.model.Member;

public interface MemberService {

   Member getMemberByld (Integer memberId) throws MemberException;
   Member getMemberByAdharNo (Long aadharNo) throws MemberException;
   Member getMemberByPanNo (String panNo) throws MemberException;
   Member addMember(Member member) throws MemberException;
   Member updateMember (Member member) throws MemberException;

   boolean deleteMember (Integer memberId);

}
