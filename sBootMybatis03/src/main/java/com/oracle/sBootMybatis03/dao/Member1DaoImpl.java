package com.oracle.sBootMybatis03.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Member1DaoImpl implements Member1Dao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public int memCount(String id) {

		System.out.println("Member1DaoImpl memCount Start...");
		int result=0;
		
		try {
			result = session.selectOne("memCount", id);
		} catch (Exception e) {
			System.out.println("Member1DaoImpl memCount Exception->"+e.getMessage());
		}
		
		return result;
	}

}
