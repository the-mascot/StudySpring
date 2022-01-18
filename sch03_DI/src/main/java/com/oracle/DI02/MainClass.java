package com.oracle.DI02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		// DI 구현
		String configLocation = "classpath:applicationCTX2.xml";
								// classpath = src/main/resources
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		MyInfo myInfo = ctx.getBean("myInfo", MyInfo.class);

		myInfo.getInfo();
		ctx.close();
	}

}
