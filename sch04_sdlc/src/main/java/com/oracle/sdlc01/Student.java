package com.oracle.sdlc01;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean {
	
	private String name;
	private int age;
	
	public void destroy() throws Exception {
		System.out.println("Student의 destroy() --> 소멸자가 소멸되기전..");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Student afterPropertiesSet --> 생성자 생성이후 자동수행");
	}

	public Student(String name, int age) {
		super();
		System.out.println("생성자 실행");
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
