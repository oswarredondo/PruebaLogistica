package com.tracusa.logistica.model;

public class Usuario {
	
    String userName;
    String password;
    String phone;
    String employeedNumber;
    String server;
    String adminKey;
    
	public Usuario() {
		super();
	}

	public Usuario(String userName, String password, String phone, String employeedNumber, String server,
			String adminKey) {
		super();
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.employeedNumber = employeedNumber;
		this.server = server;
		this.adminKey = adminKey;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmployeedNumber() {
		return employeedNumber;
	}

	public void setEmployeedNumber(String employeedNumber) {
		this.employeedNumber = employeedNumber;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getAdminKey() {
		return adminKey;
	}

	public void setAdminKey(String adminKey) {
		this.adminKey = adminKey;
	}
    
}
