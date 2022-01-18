package com.oracle.sBootJpa01.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.oracle.sBootJpa01.domain.Member;

@Repository
public class JpaMemberRepository implements MemberRepository {
	private final EntityManager em;
	public JpaMemberRepository(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public Member save(Member member) {
		System.out.println("JpaMemberRepository save Start..");
		em.persist(member);
		return member;
	}

	@Override
	public List<Member> findAll() {
		System.out.println("JpaMemberRepository findAll Start..");
		List<Member> memberList = em.createQuery("select a from Member a", Member.class)
										.getResultList();
		System.out.println("JpaMemberRepository findAll memberList.size()->"+memberList.size());
		return memberList;
	}

	@Override
	public List<Member> findByNames(String searchName) {
		String pname = '%' +searchName + '%';
		System.out.println("JpaMemberRepository findByNames pname->"+pname);
		List<Member> memberList = em.createQuery("select m from Member m where name Like :name", Member.class)
                                  .setParameter("name", pname)
                                  .getResultList();
		System.out.println("JpaMemberRepository memberList.size()->"+memberList.size());
		return memberList;
	}

}
