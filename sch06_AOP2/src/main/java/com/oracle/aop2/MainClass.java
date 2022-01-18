package com.oracle.aop2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.oracle.aop2.buz.Student;
import com.oracle.aop2.buz.Worker;

public class MainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx=new GenericXmlApplicationContext("classpath:applicationCTX2.xml");
		
		Student student=ctx.getBean("student", Student.class);
		student.getStudentInfo();
		
		Worker worker=ctx.getBean("worker", Worker.class);
		worker.getWorkerInfo();
		
		ctx.close();
		
	}

}
