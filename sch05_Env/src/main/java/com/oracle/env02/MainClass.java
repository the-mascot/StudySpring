package com.oracle.env02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx=new GenericXmlApplicationContext("classpath:applicationCTX02.xml");
		
		AdminConnection connction=ctx.getBean("adminConnection", AdminConnection.class);
		System.out.println("adminId : "+connction.getAdminId());
		System.out.println("adminPw : "+connction.getAdminPw());
		System.out.println("sub_adminId : "+connction.getSub_adminId());
		System.out.println("sub_adminPw : "+connction.getSub_adminPw());
		ctx.close();
		
		
	}

}
