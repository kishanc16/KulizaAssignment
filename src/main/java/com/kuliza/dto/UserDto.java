package com.kuliza.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
/*
 * This class taking user details from client end
 */
public class UserDto {

	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String name;
	
	@Email(message = "Email should be a valid email")
	private String email;
	
	@Size(min = 10, max = 13, message = "Mobile number should be 10 digit")
	private String phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
