package com.oracle.sBootOraConnect.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oracle.sBootOraConnect.domain.Member;

public class MemoryMemberRepository implements MemberRepository {
	
	private static Map<Integer, Member> store=new HashMap<Integer, Member>();
	private static Integer sequence=0;
	
	@Override
	public Member save(Member member) {
			
		System.out.println("MemoryMemberRepository save Start...");
			
		store.put(member.getId(), member);
		return member;
	}

	@Override
	public List<Member> findAll() {

		System.out.println("MemoryMemberRepository save Start...");
		
		return new ArrayList<Member>(store.values());
	}
	
	
	
}
