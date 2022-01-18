package com.oracle.sBootOraConnect.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oracle.sBootOraConnect.domain.Member;
import com.oracle.sBootOraConnect.repository.JdbcMemberRepository;
import com.oracle.sBootOraConnect.repository.MemberRepository;
import com.oracle.sBootOraConnect.repository.MemoryMemberRepository;

@Service
public class MemberService {
	
//	private final MemberRepository memberRepository =new MemoryMemberRepository();
//	private final MemberRepository memberRepository =new JdbcMemberRepository(dataSource);	

	private MemberRepository memberRepository;

	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository=memberRepository;
	}
	
	// 회원가입
	public void memberSave(Member member) {
		
		System.out.println("MemberService memberSave Start...");
		memberRepository.save(member);
		
	}

	// 회원 리스트 조회
	public List<Member> findMembers() {
		
		System.out.println("MemberService memberSave Start...");
		
		
		return memberRepository.findAll();
	}
	
}
