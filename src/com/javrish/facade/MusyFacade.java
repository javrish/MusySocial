package com.javrish.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusyFacade {
	List<String> songDB;
	Map<String, String> userDB;
	
	public MusyFacade() {
		initialiseSongDB();
		initialiseUserDB();
	}
	
	private void initialiseSongDB() {
		songDB = new ArrayList<>();
		songDB.add("Trampoline");
	}

	private void initialiseUserDB() {
		userDB = new HashMap<>();
		userDB.put("javrish", "jav123");
	}
	
	public boolean searchSongByName(String songName) {
		if(songDB.contains(songName))
			return true;
		
		return false;
	}

	public boolean authoriseLogin(String username, String password) {
		if(userDB.get(username) == null) {
			return false;
		}
		
		if(userDB.get(username).equals(password))
			return true;
		
		return false;
	}
}
