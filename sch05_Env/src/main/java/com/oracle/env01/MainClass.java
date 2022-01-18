package com.oracle.env01;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx=new GenericXmlApplicationContext();
		
		// App 기본 환경
		ConfigurableEnvironment env=ctx.getEnvironment();
		// App 기본 환경 --> 나의 환경 파일 추가
		MutablePropertySources propertySources=env.getPropertySources();
		try {
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
		} catch (Exception e) {
			System.out.println("MainClass Exception-."+e.getMessage());
		} 
		
		GenericXmlApplicationContext gCtx=(GenericXmlApplicationContext) ctx;
		gCtx.load("applicationCTX01.xml");
		System.out.println("MainClasss load After");
		gCtx.refresh();
		System.out.println("MainClass refresh After");
		
		AdminConnection adminConnection=gCtx.getBean("adminConnection", AdminConnection.class);
		System.out.println("MainClass adminConnection.getAdminId() : "+adminConnection.getAdminId());
		System.out.println("MainClass adminConnection.getAdminPw() : "+adminConnection.getAdminPw());
	
		gCtx.close();
		ctx.close();
		
	}
	
}
