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
		
		System.out.println("All Test Cases Passes!");
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
		assertOutput("Playing: Trampoline\nArtist: Zayn",executor.execute(command));
	}
	
	private void invalidCommandTest(String command) {
		CommandExecutor executor =  new CommandExecutor();
		assertOutput("Invalid Command!",executor.execute(command));
	}
	
	private void playMusicNotInDBTest(String command) {
		CommandExecutor executor =  new CommandExecutor();
		assertOutput("Song not found!",executor.execute(command));
	}
	
	private boolean assertOutput(String expected, String actual) {
		if(expected.equals(actual)) {
			return true;
		}
		throw new RuntimeException("Test Case Failed!\nExpected: \n"+expected +"\nActual: \n"+actual);
	}
}
