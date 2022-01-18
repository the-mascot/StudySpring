package com.oracle.aop1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.oracle.aop1.buz.Student;
import com.oracle.aop1.buz.Worker;

public class MainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx=new GenericXmlApplicationContext("classpath:applicationCTX1.xml");
		
		Student student=ctx.getBean("student", Student.class);
		// 핵심업무1
		student.getStudentInfo();
		
		Worker worker=ctx.getBean("worker", Worker.class);
		// 핵심업무2
		worker.getWorkerInfo();
		ctx.close();
		
	}

}
