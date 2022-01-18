package com.oracle.aop3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {
	@Around("within(com.oracle.aop3.buz.*)")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		// 핵심업무에서 사용 method
 		String signatureStr=joinpoint.getSignature().toString();
 		long st=System.currentTimeMillis();
 		System.out.println((signatureStr+" is start..."));
 		
 	
		try {
			// 핵심업무 수행
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			long et=System.currentTimeMillis();
			System.out.println(signatureStr+" is finished.");
			System.out.println(signatureStr+" 경과시간 : "+(et-st));
		}
 	}
 	
	@Before("within(com.oracle.aop3.buz.*)")
 	public void beforeAdvice() {
 		System.out.println("beforeAdvice()");
 	}
 	
	@After("within(com.oracle.aop3.buz.*)")
 	public void afterAdvice() {
 		System.out.println("afterAdvice()");
 	}
	
}
