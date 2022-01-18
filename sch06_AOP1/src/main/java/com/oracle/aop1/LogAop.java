package com.oracle.aop1;

import org.aspectj.lang.ProceedingJoinPoint;

// 횡단관심사의 역할
// Performance 측정
public class LogAop {
	// Around Advice 에서 사용할 공통기능 매서드는, 대부분 파라미터로 전달받은 ProceedingJoinPoint의 proceed() aptjem
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
	
}
