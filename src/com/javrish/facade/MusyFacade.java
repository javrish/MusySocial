package com.javrish.facade;

import java.util.ArrayList;
import java.util.List;

public class MusyFacade {
	List<String> songDB;
	
	public MusyFacade(){
		songDB = new ArrayList<>();
		songDB.add("Trampoline");
	}

	public boolean searchSongByName(String songName) {
		if(songDB.contains(songName))
			return true;
		
		return false;
	}

}
