package com.oracle.springMVCBoard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.oracle.springMVCBoard.dto.BDto;

public class BDao {
	
	DataSource dataSource;
	
	public BDao() {
		
		try {
			Context context=new InitialContext();
			dataSource=(DataSource)context.lookup("java:comp/env/jdbc/OracleDB");
		} catch (Exception e) {
			System.out.println("생성자 dataSource-->"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public ArrayList<BDto> list() {
		ArrayList<BDto> dtos=new ArrayList<BDto>();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		String query="select * from MVC_BOARD order by bGroup desc, bStep asc";
		
		try {
			// mvc_board order by bGroup desc, bStep asc
			connection=dataSource.getConnection();
			preparedStatement=connection.prepareStatement(query);
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				BDto dto=new BDto();
				dto.setbId(resultSet.getInt("bid"));
				dto.setbName(resultSet.getString("bname"));
				dto.setbTitle(resultSet.getString("btitle"));
				dto.setbContent(resultSet.getString("bcontent"));
				dto.setbDate(resultSet.getTimestamp("bdate"));
				dto.setbHit(resultSet.getInt("bhit"));
				dto.setbGroup(resultSet.getInt("bgroup"));
				dto.setbStep(resultSet.getInt("bstep"));
				dto.setbIndent(resultSet.getInt("bindent"));
				
				dtos.add(dto);
			}
			
			
		} catch (Exception e) {
			System.out.println("BDao list Exception->"+e.getMessage());
		} finally {
				try {
					if(connection!=null)		connection.close();
					if(preparedStatement!=null)	preparedStatement.close();
					if(resultSet!=null)			resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return dtos;
	}
	
	public BDto contentView(String bId) {
		
		System.out.println("BDao conentView 매소드 실행..");
		upHit(bId);
		BDto dto=null;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		String query="select * from mvc_board where bid=?";
		System.out.println("BDao conentView bId->"+bId);
		try {
			connection=dataSource.getConnection();
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(bId));
			resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				dto=new BDto();
				dto.setbId(resultSet.getInt("bid"));
				dto.setbName(resultSet.getString("bname"));
				dto.setbTitle(resultSet.getString("btitle"));
				dto.setbContent(resultSet.getString("bcontent"));
				dto.setbDate(resultSet.getTimestamp("bdate"));
				dto.setbHit(resultSet.getInt("bhit"));
				dto.setbGroup(resultSet.getInt("bgroup"));
				dto.setbStep(resultSet.getInt("bstep"));
				dto.setbIndent(resultSet.getInt("bindent"));
			}
			
		} catch (Exception e) {
			System.out.println("BDao contentView Exception->"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(connection!=null)		connection.close();
				if(preparedStatement!=null)	preparedStatement.close();
				if(resultSet!=null)			resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}
	
	private void upHit(String bId) {

		System.out.println("BDao upHit 매소드 실행..");
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int result=0;
		String query="update mvc_board set bhit=bhit+1 where bid=? ";
		
		try {
			connection=dataSource.getConnection();
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(bId));
			result=preparedStatement.executeUpdate();
			
			if(result==1) {
				System.out.println("upHit 성공..");
			} else {
				System.out.println("upHit 실패..");
			}
		} catch (Exception e) {
			System.out.println("BDao upHit Exception->"+e.getMessage());
		} finally {
			try {
				if(connection!=null)		connection.close();
				if(preparedStatement!=null)	preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void modify(String bId, String bName, String bTitle, String bContent) {
		
		System.out.println("BDao modify 매소드 실행..");
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int result=0;
		String query="update mvc_board set bname=?, btitle=?, bcontent=? where bid=? ";
		
		try {
			connection=dataSource.getConnection();
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setString(4, bId);
			result=preparedStatement.executeUpdate();
			
			if(result==1) {
				System.out.println("modify 성공..");
			} else {
				System.out.println("modify 실패..");
			}
		} catch (Exception e) {
			System.out.println("BDao modify Exception->"+e.getMessage());
		} finally {
			try {
				if(connection!=null)		connection.close();
				if(preparedStatement!=null)	preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void write(String bName, String bTitle, String bContent) {
		
		System.out.println("BDao write 매소드 실행..");	
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int result=0;
		String query="insert into mvc_board values(MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, sysdate, 0, MVC_BOARD_SEQ.CURRVAL, 0, 0) ";
		
		try {
			connection=dataSource.getConnection();
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			result=preparedStatement.executeUpdate();
			
			if(result==1) {
				System.out.println("write 성공..");
			} else {
				System.out.println("write 실패..");
			}
		} catch (Exception e) {
			System.out.println("BDao write Exception->"+e.getMessage());
		} finally {
			try {
				if(connection!=null)		connection.close();
				if(preparedStatement!=null)	preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public BDto reply_view(String bId) {
		
		System.out.println("BDao reply_view 매소드 실행..");	
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		BDto dto=null;
		String query="select * from mvc_board where bid=?";
		
		try {
			connection=dataSource.getConnection();
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, bId);
			resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				dto=new BDto();
				dto.setbId(resultSet.getInt("bid"));
				dto.setbName(resultSet.getString("bname"));
				dto.setbTitle(resultSet.getString("btitle"));
				dto.setbContent(resultSet.getString("bcontent"));
				dto.setbDate(resultSet.getTimestamp("bdate"));
				dto.setbHit(resultSet.getInt("bhit"));
				dto.setbGroup(resultSet.getInt("bgroup"));
				dto.setbStep(resultSet.getInt("bstep"));
				dto.setbIndent(resultSet.getInt("bindent"));
			}
		} catch (Exception e) {
			System.out.println("BDao reply_view Exception->"+e.getMessage());
		} finally {
			try {
				if(connection!=null)		connection.close();
				if(preparedStatement!=null)	preparedStatement.close();
				if(resultSet!=null)			resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}

	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep,
			String bIndent) {
		
		replyShape(bGroup, bStep);
		
		System.out.println("BDao reply 매소드 실행..");	
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int result=0;
		String query="insert into mvc_board values(MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, sysdate, 0, ?, ?, ?) ";
		
		try {
			connection=dataSource.getConnection();
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setString(4, bGroup);
			preparedStatement.setInt(5, Integer.parseInt(bStep)+1);
			preparedStatement.setInt(6, Integer.parseInt(bIndent)+1);
			result=preparedStatement.executeUpdate();
			
			if(result==1) {
				System.out.println("reply 성공..");
			} else {
				System.out.println("reply 실패..");
			}
		} catch (Exception e) {
			System.out.println("BDao reply Exception->"+e.getMessage());
		} finally {
			try {
				if(connection!=null)		connection.close();
				if(preparedStatement!=null)	preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	private void replyShape(String bGroup, String bStep) {
		
		System.out.println("BDao replyShape 매소드 실행..");	
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int result=0;
		String query="update mvc_board set bstep=bstep+1 where bgroup=? and bstep>?";
		
		try {
			connection=dataSource.getConnection();
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, bGroup);
			preparedStatement.setString(2, bStep);
			result=preparedStatement.executeUpdate();
			
			if(result==1) {
				System.out.println("replyShape 성공..");
			} else {
				System.out.println("replyShape 실패..");
			}
		} catch (Exception e) {
			System.out.println("BDao replyShape Exception->"+e.getMessage());
		} finally {
			try {
				if(connection!=null)		connection.close();
				if(preparedStatement!=null)	preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void delete(String bId) {
		
		System.out.println("BDao delete 매소드 실행..");	
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int result=0;
		String query="delete from mvc_board where bid=?";
		
		try {
			connection=dataSource.getConnection();
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, bId);
			result=preparedStatement.executeUpdate();
			
			if(result==1) {
				System.out.println("delete 성공..");
			} else {
				System.out.println("delete 실패..");
			}
		} catch (Exception e) {
			System.out.println("BDao delete Exception->"+e.getMessage());
		} finally {
			try {
				if(connection!=null)		connection.close();
				if(preparedStatement!=null)	preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
