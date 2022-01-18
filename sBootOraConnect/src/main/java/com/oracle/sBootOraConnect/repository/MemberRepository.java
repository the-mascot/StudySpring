package com.oracle.sBootOraConnect.repository;

import java.util.List;

import com.oracle.sBootOraConnect.domain.Member;

public interface MemberRepository {
	
	Member save(Member member);
	List<Member> findAll();
	
}
