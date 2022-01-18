package com.oracle.sBootMybatis03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.sBootMybatis03.dao.DeptDao;
import com.oracle.sBootMybatis03.dao.EmpDao;
import com.oracle.sBootMybatis03.dao.Member1Dao;
import com.oracle.sBootMybatis03.model.Dept;
import com.oracle.sBootMybatis03.model.DeptVo;
import com.oracle.sBootMybatis03.model.Emp;
import com.oracle.sBootMybatis03.model.EmpDept;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpDao ed;
	@Autowired
	private DeptDao dd;
	@Autowired
	private Member1Dao md;
	
	@Override
	public int total() {
		System.out.println("EmpServiceImpl total Start..." );
		int totCnt = ed.total();
		System.out.println("EmpServiceImpl total totCnt->"+totCnt );
		return totCnt;
	}

	@Override
	public List<Emp> listEmp(Emp emp) {
		
		System.out.println("EmpServiceImpl listEmp Start..." );
		List<Emp> empList = null;
		empList = ed.listEmp(emp);
		System.out.println("EmpServiceImpl listEmp empList.size()->"+empList.size());
		
		return empList;
	}

	@Override
	public Emp detail(int empno) {
		
		System.out.println("EmpServiceImpl detail Start..." );
		Emp emp = null;
		emp = ed.detail(empno);
		
		return emp;
	}

	@Override
	public int update(Emp emp) {

		System.out.println("EmpServiceImpl update Start..." );
		int kkk=ed.update(emp);
		
		return kkk;
	}
	
	// 관리자 emp만 Get
	@Override
	public List<Emp> listManager() {
		
		System.out.println("EmpServiceImpl listManager Start..." );
		List<Emp> empList = null;
		empList = ed.listManager();
		System.out.println("EmpServiceImpl listManager empList.size()->"+empList.size());
		
		return empList;
	}

	@Override
	public List<Dept> deptSelect() {

		System.out.println("EmpServiceImpl deptSelect Start...");	
		List<Dept> deptList = null;
		deptList = dd.deptSelect();
		
		return deptList;
	}

	@Override
	public int insert(Emp emp) {

		System.out.println("EmpServiceImpl insert Start...");
		int result = ed.insert(emp);
		
		return result;
	}

	@Override
	public int delete(int empno) {

		System.out.println("EmpServiceImpl delete Start...");
		int result = ed.delete(empno);
		
		return result;
	}

	@Override
	public List<EmpDept> listEmpDept() {
		
		System.out.println("EmpServiceImpl listEmpDept Start...");
		List<EmpDept> empDeptList = null;
		empDeptList = ed.listEmpDept();
		System.out.println("EmpServiceImpl listEmpDept empDeptList.size()->"+empDeptList.size());
		
		return empDeptList;
	}

	@Override
	public void insertDept(DeptVo deptVo) {

		System.out.println("EmpServiceImpl insertDept Start...");
		dd.insertDept(deptVo);
	}

	@Override
	public int memCount(String id) {

		System.out.println("EmpServiceImpl memCount Start...");
		System.out.println("EmpServiceImpl memCount id->"+id);
		
		return md.memCount(id);
	}

	@Override
	public List<EmpDept> listEmp(EmpDept empDept) {

		System.out.println("EmpServiceImpl listEmp Start...");

		return ed.listEmp(empDept);
	}

	@Override
	public String deptName(int deptno) {

		System.out.println("EmpServiceImpl deptName Start...");
		
		return ed.deptName(deptno);
	}



}
