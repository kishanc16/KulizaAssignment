package com.kuliza.dto;

import java.util.Date;

/*
 * This class is used for updating message to user when the action is correct
 **/
public class UpdatedMessageDto {
	private Date timestamp;
	private long userId;
	private String message;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
