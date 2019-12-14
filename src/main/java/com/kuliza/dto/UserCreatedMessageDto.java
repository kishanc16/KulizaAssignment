package com.kuliza.dto;

import java.util.Date;

/*
 * It is used for showing message when new user created
 * */
public class UserCreatedMessageDto {
	private Date timestamp;
	private long userId;
	private String name;
	private String message;

	public long getUserId() {
		return userId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
