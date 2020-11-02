package com.javrish.utility;

import com.javrish.dataobject.SongDO;

public class MusyUtility {

	
	public String getStringSongDisplayOutputFromSongDO(SongDO song) {
		
		String output = "";				
		output += "Playing: " +song.getSongName() +"\nArtist: "+song.getArtist();
		
		return output;
	}
	
public String getStringSongDisplayOutputFromSongDOForHistory(SongDO song) {
		
		String output = "";				
		output += song.getSongName() +"\n"+song.getArtist();
		
		return output;
	}
}
