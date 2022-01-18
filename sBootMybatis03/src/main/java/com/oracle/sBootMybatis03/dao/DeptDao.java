package com.oracle.sBootMybatis03.dao;

import java.util.List;

import com.oracle.sBootMybatis03.model.Dept;
import com.oracle.sBootMybatis03.model.DeptVo;

public interface DeptDao {
	
	List<Dept> deptSelect();

	void insertDept(DeptVo deptVo);
	
}
