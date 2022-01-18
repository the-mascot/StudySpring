package com.oracle.sBootOraConnect;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.oracle.sBootOraConnect.repository.JdbcMemberRepository;
import com.oracle.sBootOraConnect.repository.MemberRepository;
import com.oracle.sBootOraConnect.repository.MemoryMemberRepository;
import com.oracle.sBootOraConnect.service.MemberService;

@Configuration
public class SpringConfig {
	
	private final DataSource dataSource;
	
	public SpringConfig(DataSource dataSource) {
	
		this.dataSource = dataSource;
	}

//	@Bean
//	public MemberService memberService() {
//		
//		return new MemberService(memberRepository());
//	}
//	
//	@Bean
//	public MemberRepository memberRepository() {
////		return new MemoryMemberRepository();
//		return new JdbcMemberRepository(dataSource);
//	}
	
}
