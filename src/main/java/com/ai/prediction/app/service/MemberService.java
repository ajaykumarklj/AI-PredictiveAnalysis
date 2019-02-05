package com.ai.prediction.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.prediction.app.model.Member;
import com.ai.prediction.app.repository.MemberRepository;

@Service
public class MemberService {

@Autowired
private MemberRepository memberRepository;

	public List<Member> getMemberInfo(String memberId) {
		// TODO Auto-generated method stub
		return memberRepository.findByMemberId(memberId);
	}

	public Member addMember(Member member) {
		// TODO Auto-generated method stub
		return memberRepository.save(member);
	}
	
	

}
