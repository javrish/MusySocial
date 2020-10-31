package com.javrish.executor;

import com.javrish.dataobject.SongDO;
import com.javrish.dataobject.UserDO;
import com.javrish.facade.MusyFacade;

public class CommandExecutor {
	
	MusyFacade musyFacade;
	
	public CommandExecutor() {
		musyFacade = new MusyFacade();
	}
	//login javrish jav123
	public String execute(String command) {
		
		String[] input = command.split("[ ]"); //Splitting to command to understand command and values
		
		switch(input[0]) { //switch case to under the command
			case "play" : { //instruction for play command
				SongDO song;
				song = searchSongByName(input[1]); 
				if(song != null)
					return "Playing: " +song.getSongName() +"\nArtist: "+song.getArtist();
				else
					return "Song not found!";
			}
			
			case "login" : { //instruction for login command
				if(input.length < 3) { //passowrd missing check
					return "Password parameter missing!";
				}
				
				String username = input[1];
				String password = input[2];
				
				UserDO user = authoriseLogin(username,password); 
				if(user != null) //authorisation
					return user.getUsername()+" Logged in Successfully!";
				else
					return "Invalid username or password!";
			}
			
			default: {
				return "Invalid Command!";
			}
		} //END of switch
		
	} //END of execute
	
	private UserDO authoriseLogin(String username, String password) {
		return musyFacade.authoriseLogin(username,password);
		
	}
	private SongDO searchSongByName(String songName) {
		return musyFacade.searchSongByName(songName);
		
	}

}//END of class
