package com.oracle.sBootMybatis03.model;

import lombok.Getter;
import lombok.Setter;

// Join 목적
@Getter
@Setter
public class EmpDept {
	// EMP용
	private int empno; 		 private String ename;
	private String job;		 private int mgr;
	private String hiredate; private int sal;
	private int comm; 		 private int deptno;
	
	// DEPT용
	private String dname;
	private String loc;
	
}
