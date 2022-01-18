package com.oracle.springMVCBoard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oracle.springMVCBoard.command.BCommand;
import com.oracle.springMVCBoard.command.BContentCommand;
import com.oracle.springMVCBoard.command.BDeleteCommand;
import com.oracle.springMVCBoard.command.BListCommand;
import com.oracle.springMVCBoard.command.BModifyCommand;
import com.oracle.springMVCBoard.command.BReplyCommand;
import com.oracle.springMVCBoard.command.BReplyViewCommand;
import com.oracle.springMVCBoard.command.BWriteCommand;

@Controller
public class BController {
	
	BCommand command=null;
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("BController list Start...");
		command=new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("BController content_view Start...");
		model.addAttribute("request", request);
		command=new BContentCommand();
		command.execute(model);
		
		
		return "content_view";
	}
	
	@RequestMapping(value =  "/modify", method = RequestMethod.POST)
	public String modify(HttpServletRequest request, Model model) {
		
		System.out.println("BController modify Start...");
		model.addAttribute("request", request);
		command=new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		
		System.out.println("BController write_view Start...");
		
		
		return "write_view";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(HttpServletRequest request, Model model) {
		
		System.out.println("BController write Start...");
		
		model.addAttribute("request", request);
		command=new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		
		System.out.println("BController reply_view Start...");
		model.addAttribute("request", request);
		command=new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	
	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public String reply(HttpServletRequest request, Model model) {
		
		System.out.println("BController reply Start...");
		model.addAttribute("request", request);
		command=new BReplyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		
		System.out.println("BController delete Start...");
		model.addAttribute("request", request);
		command=new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
}
