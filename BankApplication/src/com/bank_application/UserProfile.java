package com.bank_application;

public class UserProfile {
	private String user_name, full_name, address, debit_card, credit_card, mobile_number, email_id;
	private String password;
	private boolean is_admin;
	
	public UserProfile(String user_name, String full_name, String address, String debit_card, String credit_card, String mobile_number, String email_id, String password, boolean is_admin) {
		this.user_name = user_name;
		this.full_name = full_name;
		this.address = address;
		this.debit_card = debit_card;
		this.credit_card = credit_card;
		this.mobile_number = mobile_number;
		this.email_id = email_id;
		this.password = password;
		this.is_admin = is_admin;
	}
	
	public String getUser_name() {
		return user_name;
	}
	
	public String getFull_name() {
		return full_name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getDebit_card() {
		return debit_card;
	}
	
	public String getCredit_card() {
		return credit_card;
	}
	
	public String getMobile_number() {
		return mobile_number;
	}
	
	public String getEmail_id() {
		return email_id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean getIs_admin() {
		return is_admin;
	}
}
