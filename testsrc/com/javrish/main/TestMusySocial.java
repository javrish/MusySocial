package com.javrish.main;

import com.javrish.executor.CommandExecutor;

public class TestMusySocial {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestMusySocial testMusySocial = new TestMusySocial();
		testMusySocial.playMusicTest("play Trampoline");
		testMusySocial.invalidCommandTest("sing Trampoline");
		
		System.out.println("All Test Cases Passes!");

	}
	
	private void playMusicTest(String command) {
		CommandExecutor executor =  new CommandExecutor();
		assertOutput("Playing: Trampoline",executor.execute(command));
		
	}
	
	private void invalidCommandTest(String command) {
		CommandExecutor executor =  new CommandExecutor();
		
		assertOutput("Invalid Command!",executor.execute(command));
		
	}
	
	private boolean assertOutput(String expected, String actual) {
		if(expected.equals(actual)) {
			return true;
		}
		throw new RuntimeException("Test Case Failed!");
	}
}
