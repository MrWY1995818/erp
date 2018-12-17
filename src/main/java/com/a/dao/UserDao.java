package com.a.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.a.domain.User;

import jdbc.JDBC_Utils;

public class UserDao {
	
	private static final String MATCH_QUERY_SQL = "select * from t_user where t_username = ? and t_password = ? ";
	private static final String INSERT_USER_SQL = "insert into t_user values(?,?)";
	private static final String UPDATE_PAAWORD_SQL = "update t_user set t_password = ? where t_username = ?";
//	private static final String DELETE_USER_SQL = "delete t_user where t_username = ?";
	
	public boolean query(User user) throws Exception{
		Connection conn = JDBC_Utils.getConnection();
		PreparedStatement stmt = conn.prepareStatement(MATCH_QUERY_SQL);
		stmt.setString(1, user.getUsername());
		stmt.setString(2, user.getPassword());
		ResultSet rs = stmt.executeQuery();
		if(!rs.next()){
//			System.out.println("用户名或密码错误");
			//抛出一个用户名或密码不匹配异常
			throw new Exception("用户名或密码不匹配异常");
			//return false;
		}
		return true;
	}
	public int insertUser(User user) throws Exception{
		Connection conn = JDBC_Utils.getConnection();
		PreparedStatement stmt = conn.prepareStatement(INSERT_USER_SQL);
		stmt.setString(1, user.getUsername());
		stmt.setString(2, user.getPassword());
		//
		return stmt.executeUpdate();
	}
	public int updateUserPassword(User user) throws Exception{
		Connection conn = JDBC_Utils.getConnection();
		PreparedStatement stmt = conn.prepareStatement(UPDATE_PAAWORD_SQL);
		stmt.setString(1, user.getPassword());
		stmt.setString(2, user.getUsername());
		//
		return stmt.executeUpdate();
	}
	
}
