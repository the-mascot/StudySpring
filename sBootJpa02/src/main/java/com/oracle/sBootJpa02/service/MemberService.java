package com.oracle.sBootJpa02.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.sBootJpa02.domain.Member;
import com.oracle.sBootJpa02.repository.MemberRepository;

@Transactional
@Service
public class MemberService {
	private final MemberRepository memberRepository;
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public Member join(Member member) {
		System.out.println("MemberService join "+member.getName());
		memberRepository.save(member);
		return member;
	}
	// 전체회원 조회
	public List<Member> getListAllMember() {
		List<Member> listMember  = memberRepository.findAll();
		System.out.println("MemberService getListAllMember listMember.size()->"
		                   +listMember.size());
		return listMember;
	}

	public Member findByMember(Long id) {
		Member member1 = memberRepository.findByMember(id);
		System.out.println("MemberService findByMember member1.getId()->"+member1.getId());
		System.out.println("MemberService findByMember member1.getName()->"+member1.getName());
		System.out.println("MemberService findByMember member1.getTeam().getName()->"
		                    +member1.getTeam().getName());
		
		return member1;
	}

	public void memberUpdate(Member member) {
		System.out.println("MemberService memberUpdate member.getName()->"+member.getName());
		System.out.println("MemberService memberUpdate member.getTeamname()->"+member.getTeamname());
		memberRepository.updateByMember(member);
		
	}
	
	
	
}
