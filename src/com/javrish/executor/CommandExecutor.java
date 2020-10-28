package com.javrish.executor;

public class CommandExecutor {
	
	public String execute(String command) {
		
		String[] input = command.split("[ ]"); //Splitting to command to understand command and values
		
		switch(input[0]) { //switch case to under the command
			case "play" : { //instruction for play command
				return "Playing: "+input[1];
			}
			default: {
				return "Invalid Command!";
			}
		} //END of switch
		
	} //END of execute

}//END of class
