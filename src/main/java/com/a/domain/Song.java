package com.a.domain;

import java.io.Serializable;

public class Song implements Serializable {
	private static final long serialVersionUID = -5517530658348504056L;
	private Integer songId;
	private String songName;
	private Integer songTime;
	
	
	public Integer getSongId() {
		return songId;
	}
	public void setSongId(Integer songId) {
		this.songId = songId;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public Integer getSongTime() {
		return songTime;
	}
	public void setSongTime(Integer songTime) {
		this.songTime = songTime;
	}
}
