package com.a.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.a.domain.UserSong;

import jdbc.JDBC_Utils;

public class UserSongDao {
	private static final String QUERY_SQL = "select * from t_user_song where t_username = ?";
	private static final String INSERT_SQL = "insert into t_user_song values(?,?)";
//	private static final String UPDATE_SQL = "update t_user_song set  where t_username = ?";
	private static final String DELETE_SQL = "delete t_user_song where t_songId = ?";
	
	public List<UserSong> queryUserSongByUsername(String username) throws Exception{
		Connection conn = JDBC_Utils.getConnection();
		PreparedStatement stmt = conn.prepareStatement(QUERY_SQL);
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		List<UserSong> list = new ArrayList<>();
		while(rs.next()){
			UserSong us = new UserSong();
			us.setSongId(rs.getInt("t_songId"));
			us.setUsername(rs.getString("t_username"));
			list.add(us);
		}
		return list;
	}
	public int insertUserSong(UserSong us) throws Exception{
		Connection conn = JDBC_Utils.getConnection();
		PreparedStatement stmt = conn.prepareStatement(INSERT_SQL);
		stmt.setInt(1, us.getSongId());
		stmt.setString(2, us.getUsername());
		return stmt.executeUpdate();
	}
	public int deleteUserSong(UserSong us) throws Exception{
		Connection conn = JDBC_Utils.getConnection();
		PreparedStatement stmt = conn.prepareStatement(DELETE_SQL);
		stmt.setInt(1, us.getSongId());
		return stmt.executeUpdate();
	}
//	public int updateUserSong(UserSong us) throws Exception{
//		Connection conn = JDBC_Utils.getConnection();
//		PreparedStatement stmt = conn.prepareStatement(DELETE_SQL);
//		stmt.setInt(1, us.getSongId());
//		return stmt.executeUpdate();
//	}
}
