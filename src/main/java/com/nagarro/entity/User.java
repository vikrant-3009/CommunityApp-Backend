package com.nagarro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class User {
	@Id
	@Email
	@NotNull
	@Column(name = "Email")
	private String email;
	
	@Column(name = "FirstName")
	@NotNull
	private String firstName;
	
	@Column(name = "LastName")
	@NotNull
	private String lastName;
	
	@Column(name = "Password")
	@NotNull
	private String password;
	
	public User() { }

	public User(@Email @NotNull String email, @NotNull String firstName, String lastName, @NotNull String password) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
