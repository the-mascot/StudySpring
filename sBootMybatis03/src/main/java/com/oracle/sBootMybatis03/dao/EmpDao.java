package com.oracle.sBootMybatis03.dao;

import java.util.List;

import com.oracle.sBootMybatis03.model.Emp;
import com.oracle.sBootMybatis03.model.EmpDept;

public interface EmpDao {
	int	total();  // Emp Row 수 

	List<Emp> listEmp(Emp emp);

	Emp detail(int empno);

	int update(Emp emp);

	List<Emp> listManager();

	int insert(Emp emp);

	int delete(int empno);

	List<EmpDept> listEmpDept();

	List<EmpDept> listEmp(EmpDept empDept);

	String deptName(int deptno);
}
