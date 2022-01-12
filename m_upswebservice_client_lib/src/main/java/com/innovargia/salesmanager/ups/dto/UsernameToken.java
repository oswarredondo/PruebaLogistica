package com.innovargia.salesmanager.ups.dto;

public class UsernameToken {
	private String Username;
	private String Password;
	
	public UsernameToken(String user, String pass){
		this.Username = user;
		this.Password = pass;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return Username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		Username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}
}
