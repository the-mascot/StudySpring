package com.oracle.sBootJpa02;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
// 1. @RunWith(SpringRunner.class) : 스프링과 테스트 통합
// 2. @SpringBootTest : 스프링 부트 띄우고 테스트(이게 없으면 @Autowired 다 실패)
// 3. @Transactional : 반복 가능한 테스트 지원, 각각의 테스트를 실행할 때마다 트랜잭션을 시작하고 
//     테스트가 끝나면 트랜잭션을 강제로 롤백 (이 어노테이션이 테스트 케이스에서 사용될 때만 롤백)

import com.oracle.sBootJpa02.domain.Member;
import com.oracle.sBootJpa02.repository.MemberRepository;
import com.oracle.sBootJpa02.service.MemberService;
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional()
public class MemberServiceTest {
	@Autowired
	MemberService memberService;
	@Autowired
	MemberRepository memberRepository;
	@Autowired	EntityManager em;
	
	@Test
//	public void memberSave() {
	public void 회원등록Test() {
		// 1. 조건
			Member member1 = new Member();
			member1.setName("kim");
			member1.setTeamname("Account");
		// 2. 실행
			memberService.join(member1);
		// 3. 결과 
			Member member2 = em.find(Member.class, member1.getId());
			System.out.println("member2.getName()->"+member2.getName());
	}
	
	
	
	
	
	
	
	

}
