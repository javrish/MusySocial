package com.javrish.executor;

public class CommandExecutor {
	
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
		return true;
		
	}

}//END of class
