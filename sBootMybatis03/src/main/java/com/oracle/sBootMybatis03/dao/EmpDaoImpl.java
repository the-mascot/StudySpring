package com.oracle.sBootMybatis03.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.sBootMybatis03.model.Emp;
import com.oracle.sBootMybatis03.model.EmpDept;

@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	private SqlSession session;
	
	@Override
	public int total() {
		
		System.out.println("EmpDaoImpl total Start ..." );
		int tot = 0;
		
		try {
			tot = session.selectOne("tkEmpTotal");
		} catch (Exception e) {
			System.out.println("EmpDaoImpl total Exception->"+e.getMessage());
		}
		
		return tot;
	}

	@Override
	public List<Emp> listEmp(Emp emp) {
		
		System.out.println("EmpDaoImpl listEmp Start ...");
		List<Emp> empList = null;
		
		try {
			empList = session.selectList("tkEmpListAll", emp);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listEmp Exception->"+e.getMessage());
		}
		
		return empList;
	}

	@Override
	public Emp detail(int empno) {
		
		System.out.println("EmpDaoImpl listEmp Start ...");
		Emp emp = new Emp();
		emp.setEmpno(empno);
		try {
			emp = session.selectOne("tkEmpSelOne", empno);
			System.out.println("EmpDaoImpl detail getEname->"+emp.getEname());
		} catch (Exception e) {
			System.out.println("EmpDaoImpl detail Exception->"+e.getMessage());
		}
		
		return emp;
	}

	@Override
	public int update(Emp emp) {
		
		System.out.println("EmpDaoImpl update Start ...");
		int kkk = 0;
		
		try {
			kkk = session.update("tkEmpUpdate", emp);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl update Exception->"+e.getMessage());
		}
		
		return kkk;
	}
	
	// 관리자만 Select
	@Override
	public List<Emp> listManager() {
		
		System.out.println("EmpDaoImpl listManager Start ...");
		List<Emp> empList = null;
		
		try {
			empList = session.selectList("tkSelectManager");
		} catch (Exception e) {
			System.out.println("EmpDaoImpl update Exception->"+e.getMessage());
		}
		
		return empList;
	}

	@Override
	public int insert(Emp emp) {

		System.out.println("EmpDaoImpl insertEmp Start ...");
		int result = 0;
		
		try {
			result = session.insert("insertEmp", emp);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl insertEmp Exception->"+e.getMessage());
		}
		
		return result;
	}

	@Override
	public int delete(int empno) {

		System.out.println("EmpDaoImpl delete Start ...");
		int result = 0;
		
		try {
			result = session.delete("delete", empno);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl delete Exception->"+e.getMessage());
		}
		
		return result;
	}

	@Override
	public List<EmpDept> listEmpDept() {
		
		System.out.println("EmpDaoImpl listEmpDept Start ...");
		List<EmpDept> empDept = null;
		
		try {
			empDept = session.selectList("TKlistEmpDept");
			System.out.println("EmpDaoImpl listEmpDept empDept.size()->"+empDept.size());
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listEmpDept Exception->"+e.getMessage());
		}
		
		
		return empDept;
	}

	@Override
	public List<EmpDept> listEmp(EmpDept empDept) {

		System.out.println("EmpDaoImpl listEmp Start...");
		
		return session.selectList("TKlistEmpDept", empDept);
	}

	@Override
	public String deptName(int deptno) {

		System.out.println("EmpDaoImpl deptName Start...");
		String dName = session.selectOne("TKdeptNmae", deptno);
		System.out.println("dName->"+dName);
		return dName;
	}

}
