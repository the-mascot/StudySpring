package com.oracle.sBootMybatis03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.sBootMybatis03.dao.MemberJpaRepository;
import com.oracle.sBootMybatis03.domain.Member;

@Service
@Transactional
public class MemberJpaService {
	
	private final MemberJpaRepository memberJpaRepository;
	
	@Autowired
	public MemberJpaService(MemberJpaRepository memberJpaRepository) {
		this.memberJpaRepository = memberJpaRepository;
	}

	public List<Member> getListAllMember() {
		
		System.out.println("MemberJpaService getListAllMember Start...");
		List<Member> listMember = memberJpaRepository.findAll();
		System.out.println("MemberJpaService getListAllMember listMember.size()->"+listMember.size());
		return listMember;
	}
	
	
	
}
