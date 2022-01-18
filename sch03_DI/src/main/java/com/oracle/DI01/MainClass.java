package com.oracle.DI01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
//		MyCalculator myCalculator = new MyCalculator();
//		Calculator calculator = new Calculator();
//		myCalculator.setCalculator(calculator);
//		myCalculator.setFirstNum(70);
//		myCalculator.setSecondNum(25);
//		
		// DI 구현
		String configLocation = "classpath:applicationCTX.xml";
								// classpath = src/main/resources
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		MyCalculator myCalculator = ctx.getBean("myCalculator", MyCalculator.class);
		
		
		// 사칙연산
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
		ctx.close();
	}

}
