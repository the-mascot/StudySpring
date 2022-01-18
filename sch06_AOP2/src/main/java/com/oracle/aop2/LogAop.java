package com.oracle.aop2;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	
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
 	
 	public void beforeAdvice() {
 		System.out.println("beforeAdvice()");
 	}
 	
 	public void afterReturningAdvice() {
 		System.out.println("afterReturningAdvice()");
 	}
 	
 	public void afterThrowingAdvice() {
 		System.out.println("afterThrowingAdvice()");
 	}
 	
 	public void afterAdvice() {
 		System.out.println("afterAdvice()");
 	}
 	
}
 	
