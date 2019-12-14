package com.kuliza.dto;

import java.util.Date;

/*
 * This class is used for updating message to user when the action is not correct
 **/
public class ErrorDetailsDto {
	private Date timestamp;
	private String message;
	private String details;

	public ErrorDetailsDto(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}
