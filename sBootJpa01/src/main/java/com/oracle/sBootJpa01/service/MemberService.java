package com.oracle.sBootJpa01.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.sBootJpa01.domain.Member;
import com.oracle.sBootJpa01.repository.MemberRepository;

@Transactional
@Service
public class MemberService {
	private final MemberRepository memberRepository;
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	// 회원가입
	public Long join(Member member) {
		System.out.println("MemberService join member.getId()->"+member.getId());
		memberRepository.save(member);
		return member.getId();
	}
	
	// 전체회원 조회
	public List<Member> getListAllMember() {
		System.out.println("MemberService getListAllMember start..");
		List<Member> listMember = memberRepository.findAll();
		
		return listMember;
	}
	
	// 조건 조회 
	public List<Member> getListSearchMember(String searchName) {
		System.out.println("MemberService getListSearchMember Start...");
		// String pSearchName = searchName + '%';
		System.out.println("MemberService getListSearchMember searchName->"+searchName);
		List<Member> listMember  = memberRepository.findByNames(searchName);
		System.out.println("MemberService getListSearchMember listMember.size()->"+listMember.size());
		return listMember;
	}
	
	
}
