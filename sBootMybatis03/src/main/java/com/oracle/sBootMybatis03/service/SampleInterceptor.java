package com.oracle.sBootMybatis03.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter {
	
	public SampleInterceptor() {
	}
	
	// 나중에 수행되는 매서드
	public void postHandle(	HttpServletRequest	request, 
							HttpServletResponse response,
							Object 				handler,
							ModelAndView		modelAndView) {
		System.out.println("SampleInterceptor 3. postHandle Start...");
	}
	
	// 먼저 수행되는 메서드
	public boolean preHandle(	HttpServletRequest request, 
								HttpServletResponse response,
								Object 				handler) {
		
		System.out.println("SampleInterceptor 1. preHandle Start...");
		
		return true;
	}
	
}
