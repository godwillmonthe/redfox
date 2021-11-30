package com.redfox.model.BEAN;

public class Admin extends Employee{

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String firstname, String lastname, String emailAddress, String password, boolean isAdmin) {
		super(firstname, lastname, emailAddress, password, isAdmin);
		// TODO Auto-generated constructor stub
	}

	public String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
