package com.oracle.sBootMybatis03.service;

import java.util.List;

import com.oracle.sBootMybatis03.model.Dept;
import com.oracle.sBootMybatis03.model.DeptVo;
import com.oracle.sBootMybatis03.model.Emp;
import com.oracle.sBootMybatis03.model.EmpDept;

public interface EmpService {
	int total();
	List<Emp> listEmp(Emp emp);
	Emp detail(int empno);
	int update(Emp emp);
	List<Emp> listManager();
	List<Dept> deptSelect();
	int insert(Emp emp);
	int delete(int empno);
	List<EmpDept> listEmpDept();
	void insertDept(DeptVo deptVo);
	int memCount(String id);
	List<EmpDept> listEmp(EmpDept empDept);
	String deptName(int deptno);

}
