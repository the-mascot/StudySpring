package com.oracle.sBootJpa02.repository;

import java.util.List;

import com.oracle.sBootJpa02.domain.Member;

public interface MemberRepository {
	Member       save(Member member);
	List<Member> findAll();
	Member       findByMember(Long id);
	int          updateByMember(Member member);

}
