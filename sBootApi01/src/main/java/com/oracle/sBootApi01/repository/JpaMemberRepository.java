package com.oracle.sBootApi01.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.oracle.sBootApi01.domain.Member;

@Repository
public class JpaMemberRepository implements MemberRepository {
	
	private final EntityManager em;
	
	public JpaMemberRepository(EntityManager em) {
		this.em = em;
	}



	@Override
	public List<Member> findAll() {
		
		List<Member> memberList = em.createQuery("select m from Member m", Member.class).getResultList();
		System.out.println("JpaMemberRepository findAll memberList.size()->"+memberList.size());
		
		return memberList;
	}

}
