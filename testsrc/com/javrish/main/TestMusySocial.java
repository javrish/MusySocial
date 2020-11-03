package com.javrish.main;

import com.javrish.executor.CommandExecutor;

public class TestMusySocial {
	
	public static void main(String[] args) {
		
		TestMusySocial testMusySocial = new TestMusySocial();
		testMusySocial.playMusicTest("play Trampoline");
		testMusySocial.invalidCommandTest("sing Trampoline");
		testMusySocial.playMusicNotInDBTest("play Mood");
		testMusySocial.loginUserSuccessTest("login javrish jav123");
		testMusySocial.loginInvalidUserTest("login truth warrior");
		testMusySocial.loginWithoutPasswordFailsTest("login javrish");
		testMusySocial.loginWithMoreThanThreeInputsPassIgnoringTheExtraParameter("login javrish jav123 hey");
		testMusySocial.playWithoutLoginPromptsUserToLogin("play Trampoline");
		testMusySocial.showPlayHistory("history");
		testMusySocial.showPlayHistoryWithoutLoginFails("history");
		testMusySocial.showPlayHistoryEmptyHistoryTestWhenNoSongIsPlayedYet("history");
		testMusySocial.getSongList("list");
		
		System.out.println("All Test Cases Passes!");
	}
	
	private void getSongList(String command) {
		CommandExecutor executor = new CommandExecutor();
		executor.execute("login javrish jav123");
		
		assertOutput("1. Trampoline\n" + 
				"Zayn\n" + 
				"2. SomeoneYouLoved\n" + 
				"Lewis Capaldi\n",executor.execute(command));
	}

	private void showPlayHistoryEmptyHistoryTestWhenNoSongIsPlayedYet(String command) {
		CommandExecutor executor = new CommandExecutor();
		executor.execute("login javrish jav123");
		executor.execute("History");
		
		assertOutput("Empty History!\nPlay some song to get it on history.",executor.execute(command));
		
	}

	private void showPlayHistoryWithoutLoginFails(String command) {
		CommandExecutor executor = new CommandExecutor();
		assertOutput("Please login to use this command!",executor.execute(command));
	}

	private void showPlayHistory(String command) {
		CommandExecutor executor = new CommandExecutor();
		executor.execute("login javrish jav123");
		executor.execute("play Trampoline");
		
		assertOutput("Trampoline\nZayn",executor.execute(command));
	}

	private void playWithoutLoginPromptsUserToLogin(String command) {
		CommandExecutor executor = new CommandExecutor();
		assertOutput("Please login to use this command!",executor.execute(command));
	}

	private void loginWithMoreThanThreeInputsPassIgnoringTheExtraParameter(String command) {
		CommandExecutor executor = new CommandExecutor();
		assertOutput("javrish Logged in Successfully!",executor.execute(command));
	}

	private void loginWithoutPasswordFailsTest(String command) {
		CommandExecutor executor = new CommandExecutor();
		assertOutput("Password parameter missing!",executor.execute(command));
	}

	private void loginInvalidUserTest(String command) {
		CommandExecutor executor = new CommandExecutor();
		assertOutput("Invalid username or password!",executor.execute(command));
	}

	private void loginUserSuccessTest(String command) {
		CommandExecutor executor = new CommandExecutor();
		assertOutput("javrish Logged in Successfully!",executor.execute(command));
	}

	private void playMusicTest(String command) {
		CommandExecutor executor =  new CommandExecutor();
		executor.execute("login javrish jav123");
		assertOutput("Playing: Trampoline\nArtist: Zayn",executor.execute(command));
	}
	
	private void invalidCommandTest(String command) {
		CommandExecutor executor =  new CommandExecutor();
		assertOutput("Invalid Command!",executor.execute(command));
	}
	
	private void playMusicNotInDBTest(String command) {
		CommandExecutor executor =  new CommandExecutor();
		executor.execute("login javrish jav123");
		assertOutput("Song not found!",executor.execute(command));
	}
	
	private boolean assertOutput(String expected, String actual) {
		if(expected.equals(actual)) {
			return true;
		}
		throw new RuntimeException("Test Case Failed!\nExpected: \n"+expected +"\nActual: \n"+actual);
	}
}
