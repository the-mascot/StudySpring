package com.oracle.sBootOraConnect.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import com.oracle.sBootOraConnect.domain.Member;

@Repository
public class JdbcMemberRepository implements MemberRepository {
	
	private final DataSource dataSource;
	
	public JdbcMemberRepository(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public Connection getConnecntion() {
	 
		return DataSourceUtils.getConnection(dataSource);
	}
	
	@Override
	public Member save(Member member) {
		System.out.println("JdbcMemberRepository save Start...");
		
		String sql="insert into member(id, name) values(?, ?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=getConnecntion();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("save Exception->"+e.getMessage());
		} finally {
				try {
					if(conn!=null)	conn.close();
					if(pstmt!=null)	pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return member;
	}

	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
