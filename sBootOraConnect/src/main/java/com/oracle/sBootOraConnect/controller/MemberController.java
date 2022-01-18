package com.oracle.sBootOraConnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.oracle.sBootOraConnect.domain.Member;
import com.oracle.sBootOraConnect.service.MemberService;

@Controller
public class MemberController {
	
//	private final MemberService memberService=new MemberService();
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	// 저장 위한 Form
	@GetMapping("/members/new")
	public String membersNew() {

		System.out.println("MemberController membersNew Get Start...");
		return "members/createMemberForm";
	}
	
	// 진짜 저장
	@PostMapping("/members/new")
	public String membersNewSave(Member member) {
		System.out.println("MemberController membersNewSave Post Start...");
		System.out.println("MemberController membersNewSave member.getId()->"+member.getId());
		System.out.println("MemberController membersNewSave member.getName()->"+member.getName());
		memberService.memberSave(member);
		
		return "redirect:/";
	}
	
	@GetMapping("/")
	public String home() {
		
		System.out.println("MemberController home Start...");
		
		return "home";
	}
	
	@GetMapping("/members")
	public String memberList(Model model) {
		
		System.out.println("MemberController memberList Start...");
		List<Member> memList=memberService.findMembers();
		System.out.println("MemberController memberList memList.size()->"+memList.size());
		model.addAttribute("members", memList);
		
		return "members/memberList";
	}
	
}
