package com.a.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.a.domain.Song;
import com.a.domain.User;
import com.a.domain.UserSong;

import jdbc.JDBC_Utils;

public class SongDao {
	private static final String QUERY_SQL = "select * from t_song where t_songId = ? ";
	private static final String INSERT_SONG_SQL = "insert into t_song values(?,?,?)";
	private static final String UPDATE_SONG__QUERY_SQL = "update t_song set ???";
	private static final String DELETE_SONG_SQL = "delete t_song where t_songid = ?";
	
	public List<Song> querySong(Song s) throws Exception{
		Connection conn = JDBC_Utils.getConnection();
		PreparedStatement stmt = conn.prepareStatement(QUERY_SQL);
		stmt.setInt(1, s.getSongId());
		ResultSet rs = stmt.executeQuery();
		List<Song> list = new ArrayList<>();
		while(rs.next()){
			Song s1 = new Song();
			s1.setSongId(rs.getInt("t_songId"));
			s1.setSongName(rs.getString("t_songName"));
			s1.setSongTime(rs.getInt("t_songTime"));
			list.add(s);
		}
		return list;
	}
	
	
	
	
}
