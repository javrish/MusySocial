package com.javrish.dataobject;

import java.util.ArrayList;
import java.util.List;

public class UserDO {
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private long userId;
	private List<String> history;
	
	public UserDO (){
		history = new ArrayList<>();
	}
	
	
	/**
	 * @return the userName
	 */
	public String getUsername() {
		return userName;
	}
	/**
	 * @return the history
	 */
	public List<String> getHistory() {
		return history;
	}
	/**
	 * @param history the history to set
	 */
	public void setHistory(String newSongPlayed) {
		this.history.add(newSongPlayed);
	}
	/**
	 * @param username the userName to set
	 */
	public void setUsername(String username) {
		this.userName = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "UserDO [userName=" + userName + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", userId=" + userId + "]";
	}
	
}