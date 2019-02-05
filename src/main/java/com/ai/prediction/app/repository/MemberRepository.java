package com.ai.prediction.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ai.prediction.app.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	
	List<Member> findByMemberId(String memberId);
	

}
