package com.redfox.model.BEAN;

public class Employee {
	private String firstname, lastname, emailAddress, password;

	public Employee() {
		super();
		// TODO mmmmhhh
	}

	public Employee(String firstname, String lastname, String emailAddress, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailAddress = emailAddress;
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
