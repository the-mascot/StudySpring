package com.oracle.sdlc01;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class OtherStudent {
	
	private String name;
	private int age;
	
	public OtherStudent(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	// 생성자 생성 이후
	@PostConstruct
	public void initMethod() {
		System.out.println("OtherStudent의 initMethod()");
	}
	
	// Instance 소멸 전
	@PreDestroy
	public void destroyMethod() {
		System.out.println("OtherStudent의 destroyMethod()");
	}
	
}
