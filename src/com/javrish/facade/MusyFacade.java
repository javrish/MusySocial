package com.javrish.facade;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.javrish.dataobject.SongDO;
import com.javrish.dataobject.UserDO;
import com.javrish.utility.MusyUtility;

public class MusyFacade {
	Map<String, SongDO> songDB;
	Map<String, UserDO> userDB;
	
	MusyUtility musyUtility;
	
	public MusyFacade() {
		initialiseSongDB();
		initialiseUserDB();
		musyUtility = new MusyUtility();
	}
	
	private void initialiseSongDB() {
		songDB = new HashMap<>();
		SongDO song = new SongDO();
		
		song.setSongName("Trampoline");
		song.setSongId(10001l);
		song.setArtist("Zayn");
		
		SongDO song2 = new SongDO();
		
		song2.setSongName("SomeoneYouLoved");
		song2.setSongId(10002l);
		song2.setArtist("Lewis Capaldi");
		
		songDB.put(song.getSongName(),song);
		songDB.put(song2.getSongName(),song2);
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

	public String getHistoryForUser(UserDO user) {
		List<String> history = user.getHistory();
		String output = "";
		String lineBreak = "";
		if(history.size() > 1) {
			lineBreak = "\n";
		}
		for(String song: history) {
			output += getStringSongDisplayOutputFromSongDOForHistory(searchSongByName(song))+lineBreak;
		}
		
		return output;
	}
	
	public String getStringSongDisplayOutputFromSongDO(SongDO song) {
		return musyUtility.getStringSongDisplayOutputFromSongDO(song);
	}
	
	public String getStringSongDisplayOutputFromSongDOForHistory(SongDO song) {
		return musyUtility.getStringSongDisplayOutputFromSongDOForHistory(song);
	}

	public String getSongList() {
		
		String output = "";
		Set<String> keySet = songDB.keySet();
		String lineBreak = "";
		if(keySet.size() > 1) {
			lineBreak = "\n";
		}
		int i = 1;
		for(String key : keySet) {
			output += i++ +". "+musyUtility.getStringSongDisplayOutputFromSongDOForHistory(songDB.get(key)) + lineBreak;
		}	
		
		return output;
	}

}
