package com.oracle.sBootJpa02.repository;

import java.util.List;

import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import com.oracle.sBootJpa02.domain.Member;
import com.oracle.sBootJpa02.domain.Team;

@Repository
public class JpaMemberRepository implements MemberRepository {
	private final EntityManager em;
	    
	public JpaMemberRepository(EntityManager em) {
	    this.em = em;
	}

	@Override
	public Member save(Member member) {
		// Team 저장
		Team team  = new Team();
		team.setName(member.getTeamname());
		em.persist(team);
		System.out.println("----JpaMemberRepository save Team1 저장----");
		// 회원 저장
		member.setTeam(team);
		System.out.println("----JpaMemberRepository save Team2 저장----");
		em.persist(member);
		System.out.println("----JpaMemberRepository save member 저장----");
		
		return member;
	}

	@Override
	public List<Member> findAll() {
		List<Member> memberList = em.createQuery("select m from Member m", Member.class)
				                  .getResultList();
		return memberList;
	}
    // 하나의 Row 조회
	@Override
	public Member findByMember(Long id) {
		Member member = em.find(Member.class, id);
		return member;
	}

	@Override
	public int  updateByMember(Member member) {
		int result = 0;
		
		System.out.println("JpaMemberRepository updateByMember member.getId()->"+member.getId());
		Member member3 = em.find(Member.class, member.getId());
		if (member3 != null ) {
			// 팀저장 
	   		 System.out.println("JpaMemberRepository updateByMember member.getTeamid()->"
			                     +member.getTeamid());
	   		Team team = em.find(Team.class, member.getTeamid());
			if (team != null) {
	 	   		System.out.println("JpaMemberRepository updateByMember member.getTeamname()->"+member.getTeamname());
		 	  	team.setName(member.getTeamname());
			}
			// 회원 저장
	 	   	 System.out.println("JpaMemberRepository updateByMember member.getName()->"+member.getName());
			member3.setTeam(team);
			member3.setName(member.getName());
			result = 1;
		} else {
			result = 0;
		}
		
		
		
		return result;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
