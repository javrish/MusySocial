package com.javrish.dataobject;

public class SongDO {

	private String songName;
	private long songId;
	private String artist;
	
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public long getSongId() {
		return songId;
	}
	public void setSongId(long songId) {
		this.songId = songId;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	@Override
	public String toString() {
		return "SongDO [songName=" + songName + ", songId=" + songId + ", artist=" + artist + "]";
	}
	
}