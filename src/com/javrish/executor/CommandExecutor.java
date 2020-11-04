package com.javrish.executor;

import com.javrish.BD.MusyBD;
import com.javrish.dataobject.SongDO;
import com.javrish.dataobject.UserDO;
import com.javrish.facade.MusyFacade;

public class CommandExecutor {
	
	MusyFacade musyFacade;
	MusyBD musyBD;
	
	public CommandExecutor() {
		musyFacade = new MusyFacade();
		musyBD = new MusyBD();
	}
	//login javrish jav123
	public String execute(String command) {
		
		String[] input = command.split("[ ]"); //Splitting to command to understand command and values
		
		switch(input[0]) { //switch case to under the command
			case "play" : { //instruction for play command
				if(!musyBD.isLoggedIn()) {
					return "Please login to use this command!";
				}
				
				SongDO song;
				song = musyBD.searchSongByName(input[1]);
				
				if(song != null) {
					musyBD.getUser().setHistory(input[1]); //Add song to logged in users history
					return musyFacade.getStringSongDisplayOutputFromSongDO(song);
				}
				else
					return "Song not found!";
			}
			
			case "login" : { //instruction for login command
				if(input.length < 3) { //Password missing check
					return "Password parameter missing!";
				}
				
				String userName = input[1];
				String password = input[2];
				
				UserDO user = musyBD.authoriseLogin(userName,password); 
				
				if(user != null) {//Authorization
					musyBD.setUser(user);
					return user.getUsername()+" Logged in Successfully!";
				}
				
				else
					return "Invalid username or password!";
			}
			
			case "history" : { //show user song history
				
				if(!musyBD.isLoggedIn()) {
					return "Please login to use this command!";
				}
				
				String output = musyBD.getHistoryForUser();
				if(output.isEmpty()) {
					output = "Empty History!\nPlay some song to get it on history.";
				}
				return output;
			}
			
			case "list" : { //get list of songs to play
				
				if(!musyBD.isLoggedIn()) {
					return "Please login to use this command!";
				}
				
				String output = musyBD.getSongList();
				
				return output;
			}
			
			default: {
				return "Invalid Command!";
			}
		} //END of switch
		
	} //END of execute

}//END of class
