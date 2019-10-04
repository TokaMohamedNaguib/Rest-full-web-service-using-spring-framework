package com.restfull.web.services.idealwaves.task.exception;

import java.util.Date;

import javax.xml.crypto.Data;

public class ErrorMessage {

	private Date timestamp;
	private String message;

	public ErrorMessage(Date timestamp, String message) {
		super();
		this.timestamp = timestamp;
		this.message = message;
	}

	public ErrorMessage() {
		super();
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
