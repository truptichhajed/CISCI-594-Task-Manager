package org.taskmanager.error;

import org.taskmanager.model.User;

public class ResponseMessage {
	private int status;
	private String message;
	private User user;
	
	public ResponseMessage() {
		
	}
	
	public ResponseMessage(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	public ResponseMessage(String message, User user) {
		super();
		this.message = message;
		this.user = user;
	}
	
	public ResponseMessage(int status, String message, User user) {
		super();
		this.status = status;
		this.message = message;
		this.user = user;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
