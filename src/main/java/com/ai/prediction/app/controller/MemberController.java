package com.ai.prediction.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ai.prediction.app.model.Member;
import com.ai.prediction.app.model.Provider;
import com.ai.prediction.app.service.MemberService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/member")
public class MemberController {
	
@Autowired
@Qualifier("memberService")
private MemberService memberService;
	
	@GetMapping("/memberId/{memberId}")
	public Member getMemberInfo(@PathVariable(value = "memberId") String memberId) {
		
		Member member= null;
		List<Member> members=memberService.getMemberInfo(memberId);
		if(members!=null && !members.isEmpty())
		{
			member=members.get(0);
		}
		return member;
	    //return memberService.getMemberInfo(memberId);
	}
	
	@PostMapping("/add")
	public Member addMember(@Valid @RequestBody Member member)
	{
		return memberService.addMember(member);
	}

}
