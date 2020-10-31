package com.javrish.main;

import java.util.Scanner;

import com.javrish.executor.CommandExecutor;

public class MusyRunner {

	public static void main(String[] args) {

		CommandExecutor executor = new CommandExecutor();
		String command;
		Scanner sc = new Scanner(System.in);
		while (!(command = sc.nextLine()).equals("q")) {
			System.out.println(executor.execute(command));
		}
	}
}
