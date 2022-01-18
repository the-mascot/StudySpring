package com.oracle.sBootMybatis03.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.sBootMybatis03.model.Dept;
import com.oracle.sBootMybatis03.model.DeptVo;

@Repository
public class DeptDaoImpl implements DeptDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Dept> deptSelect() {

		System.out.println("DeptDaoImpl deptSelect Start...");
		List<Dept> deptList = null;
		
		try {
			deptList = session.selectList("tkSelectDept");
			System.out.println("DeptDaoImpl deptSelect deptList.size()->"+deptList.size());
		} catch (Exception e) {
			System.out.println("DeptDaoImpl deptSelect Exception->"+e.getMessage());
		}
		
		return deptList;
	}

	@Override
	public void insertDept(DeptVo deptVo) {

		System.out.println("DeptDaoImpl insertDept Start...");
		
		try {
			session.selectOne("ProcDept", deptVo);
		} catch (Exception e) {
			System.out.println("DeptDaoImpl insertDept Exception->"+e.getMessage());
		}
	}

}
