package com.a.domain;

import java.io.Serializable;

public class UserSong implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer songId;
	private String username;
	public Integer getSongId() {
		return songId;
	}
	public void setSongId(Integer songId) {
		this.songId = songId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
