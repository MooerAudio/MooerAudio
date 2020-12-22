package com.mooer.manager.gtrs.entity;

import org.hibernate.validator.constraints.NotBlank;

public class UserLogin {
	
	@NotBlank(message = "username cannot be empty")
	private String username;
	
	@NotBlank(message = "password cannot be empty")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
