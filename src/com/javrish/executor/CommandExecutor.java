package com.javrish.executor;

import com.javrish.facade.MusyFacade;

public class CommandExecutor {
	
	MusyFacade musyFacade;
	
	public CommandExecutor() {
		musyFacade = new MusyFacade();
	}
	
	public String execute(String command) {
		
		String[] input = command.split("[ ]"); //Splitting to command to understand command and values
		
		switch(input[0]) { //switch case to under the command
			case "play" : { //instruction for play command
				if(searchSongByName(input[1]))
					return "Playing: "+input[1];
				else
					return "Song not found!";
			}
			default: {
				return "Invalid Command!";
			}
		} //END of switch
		
	} //END of execute
	
	private boolean searchSongByName(String songName) {
		
		return musyFacade.searchSongByName(songName);
		
	}

}//END of class
