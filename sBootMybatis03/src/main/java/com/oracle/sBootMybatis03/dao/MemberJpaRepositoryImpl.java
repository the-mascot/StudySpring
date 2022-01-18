package com.oracle.sBootMybatis03.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.oracle.sBootMybatis03.domain.Member;

@Repository
public class MemberJpaRepositoryImpl implements MemberJpaRepository {
	
	private final EntityManager em;
	
	public MemberJpaRepositoryImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Member> findAll() {

		System.out.println("MemberJpaRepositoryImpl findAll Start...");
		List<Member> listMember = em.createQuery("select m from Member m", Member.class).getResultList();
		
		return listMember;
	}

}
