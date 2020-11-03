package com.javrish.executor;

import com.javrish.dataobject.SongDO;
import com.javrish.dataobject.UserDO;
import com.javrish.facade.MusyFacade;

public class CommandExecutor {
	
	MusyFacade musyFacade;
	UserDO user;
	
	public CommandExecutor() {
		musyFacade = new MusyFacade();
		user = null;
	}
	//login javrish jav123
	public String execute(String command) {
		
		String[] input = command.split("[ ]"); //Splitting to command to understand command and values
		
		switch(input[0]) { //switch case to under the command
			case "play" : { //instruction for play command
				if(!isLoggedIn()) {
					return "Please login to use this command!";
				}
				
				SongDO song;
				song = searchSongByName(input[1]);
				
				if(song != null) {
					user.setHistory(input[1]); //Add song to logged in users history
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
				
				UserDO user = authoriseLogin(userName,password); 
				
				if(user != null) {//Authorization
					this.user = user;
					return user.getUsername()+" Logged in Successfully!";
				}
				
				else
					return "Invalid username or password!";
			}
			
			case "history" : { //show user song history
				
				if(!isLoggedIn()) {
					return "Please login to use this command!";
				}
				
				String output = getHistoryForUser();
				if(output.isEmpty()) {
					output = "Empty History!\nPlay some song to get it on history.";
				}
				return output;
			}
			
			case "list" : { //get list of songs to play
				
				if(!isLoggedIn()) {
					return "Please login to use this command!";
				}
				
				String output = getSongList();
				
				return output;
			}
			
			default: {
				return "Invalid Command!";
			}
		} //END of switch
		
	} //END of execute
	
	private String getSongList() {
		return musyFacade.getSongList();
	}
	
	private String getHistoryForUser() {
		return musyFacade.getHistoryForUser(user);
	}
	
	private boolean isLoggedIn() {
		return user!=null;
	}
	
	private UserDO authoriseLogin(String username, String password) {
		return musyFacade.authoriseLogin(username,password);
	}
	
	private SongDO searchSongByName(String songName) {
		return musyFacade.searchSongByName(songName);	
	}

}//END of class
