package com.Bean;

import javax.validation.constraints.Size;

import com.validated.ValidatedUser1;

public class User {
	@Size(min=1,max=6,message="{user.name}",groups={ValidatedUser1.class})
	private String name;
	@Size(min=1,max=1,message="{user.password}")
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	

}
