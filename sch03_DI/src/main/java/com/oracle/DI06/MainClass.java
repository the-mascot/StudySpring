package com.oracle.DI06;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String configLocation1="classpath:applicationCTX610.xml";
		String configLocation2="classpath:applicationCTX611.xml";
		AbstractApplicationContext ctx=
				new GenericXmlApplicationContext(configLocation1, configLocation2);
		
		Student stdudent1=ctx.getBean("student1", Student.class);
		System.out.println(stdudent1.getName());
		System.out.println(stdudent1.getHobbys());
		
		StudentInfo studentInfo=ctx.getBean("studentInfo1", StudentInfo.class);
		Student student2=studentInfo.getStudent();
		System.out.println(student2.getName());
		System.out.println(student2.getHobbys());
		
		if(stdudent1.equals(student2)) {
			System.out.println("student1==student2");
		}
		
		Student student3=ctx.getBean("student3", Student.class);
		Student student4=ctx.getBean("student3", Student.class);
		System.out.println(student3.getName());
		
		if(stdudent1.equals(student3)) {
			System.out.println("student1==student3");
		} else {
			System.out.println("student1!=student3");
		}
		
		if(student3.equals(student4)) {
			System.out.println("student3==student4");
		} else {
			System.out.println("student3!=student4");
		}
		
	}

}
