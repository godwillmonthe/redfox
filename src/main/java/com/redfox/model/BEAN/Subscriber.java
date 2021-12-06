package com.redfox.model.BEAN;

import java.util.List;

public class Subscriber {
	private String firstname, surname, emailAddress, password;
	private List<String> genre;
	
	public Subscriber() {
		super();
	}
	public Subscriber(String firstname, String surname, String emailAddress, String password) {
		super();
		this.firstname = firstname;
		this.surname = surname;
		this.emailAddress = emailAddress;
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
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
	public List<String> getGenre() {
		return genre;
	}
	public void setGenre(List<String> genre) {
		this.genre = genre;
	}
	
}
