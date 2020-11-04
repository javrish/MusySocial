package com.javrish.BD;

import com.javrish.dataobject.SongDO;
import com.javrish.dataobject.UserDO;
import com.javrish.facade.MusyFacade;

public class MusyBD {

	MusyFacade musyFacade;
	private UserDO user;

	public MusyBD() {
		musyFacade = new MusyFacade();
		user = null;
	}
	
	public String getSongList() {
		return musyFacade.getSongList();
	}
	
	public String getHistoryForUser() {
		return musyFacade.getHistoryForUser(user);
	}
	
	public boolean isLoggedIn() {
		return user!=null;
	}
	
	public UserDO authoriseLogin(String username, String password) {
		return musyFacade.authoriseLogin(username,password);
	}
	
	public SongDO searchSongByName(String songName) {
		return musyFacade.searchSongByName(songName);	
	}

	public UserDO getUser() {
		return user;
	}

	public void setUser(UserDO user) {
		this.user = user;
	}
	
}
