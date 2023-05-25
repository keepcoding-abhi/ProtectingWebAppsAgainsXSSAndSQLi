package com.bank_application;

public class LoginCredentials {
	private String username;
	private boolean is_admin;
	
	public LoginCredentials(String username, boolean is_admin) {
		this.is_admin = is_admin;
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public boolean getIs_admin() {
		return is_admin;
	}
}
