package com.javrish.facade;

import java.util.HashMap;
import java.util.Map;

import com.javrish.dataobject.SongDO;
import com.javrish.dataobject.UserDO;

public class MusyFacade {
	Map<String, SongDO> songDB;
	Map<String, UserDO> userDB;
	
	public MusyFacade() {
		initialiseSongDB();
		initialiseUserDB();
	}
	
	private void initialiseSongDB() {
		songDB = new HashMap<>();
		SongDO song = new SongDO();
		
		song.setSongName("Trampoline");
		song.setSongId(10001l);
		song.setArtist("Zayn");
		
		songDB.put(song.getSongName(),song);
	}

	private void initialiseUserDB() {
		userDB = new HashMap<>();
		UserDO user = new UserDO();
		
		user.setUsername("javrish");
		user.setPassword("jav123");
		user.setUserId(1000001l);
		user.setFirstName("Rishabh");
		user.setLastName("Pathak");
		
		userDB.put("javrish", user);
	}
	
	public SongDO searchSongByName(String songName) {
		if(songDB.containsKey(songName))
			return songDB.get(songName);
		
		return null;
	}

	public UserDO authoriseLogin(String username, String password) {
		
		UserDO user = userDB.get(username);
		
		if(user == null) {
			return user;
		}
		
		if(user.getPassword().equals(password))
			return user;
		
		return user;
	}
}
