package com.oracle.sBootApi01.controller;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.sBootApi01.domain.Member;
import com.oracle.sBootApi01.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

// @RestController ?
// Controller + ResponseBody
// 1. API 용도
// 2. AJAX 용도

@RestController
@RequiredArgsConstructor	// lombok 생성자 자동생성
public class JpaRestApiController {
	
	private final MemberService memberService;
	
	// Bad API
	@GetMapping("/restApi/v1/members")
	public List<Member> membersV1() {
		System.out.println("JpaRestApiController /restApi/v1/members Start...");
		List<Member> listMemberV1 = memberService.getListAllMember();
		
		return listMemberV1;
	}
	
	// Good API
	@GetMapping("/restApi/v2/members")
	public Result membersV2() {
		System.out.println("JpaRestApiController /restApi/v2/members Start...");
		List<Member> findMembers = memberService.getListAllMember();
		//  자바 8에서 추가한 스트림(Streams)은 람다를 활용할 수 있는 기술 중 하나
		List<MemberRtnDto> memberCollect = findMembers.stream().map(m->new MemberRtnDto(m.getName())).collect(Collectors.toList());

		
		
		return new Result(memberCollect.size(), memberCollect);
	}
	
	@Data
	@AllArgsConstructor
	class MemberRtnDto {
		private String name;
		
	}
	
	@Data
	@AllArgsConstructor
	class Result<T> {
		private int totCount;
		private T data;
	}
	
}
