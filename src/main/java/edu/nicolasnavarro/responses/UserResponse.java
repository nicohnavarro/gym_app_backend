package edu.nicolasnavarro.responses;

import edu.nicolasnavarro.dao.UserDTO;

public class UserResponse implements EntitiesApplication<UserDTO> {
	
	private UserDTO user;
	private String message;
	private int statusCode;
	
	public UserResponse(UserDTO user) {
		this.user=user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public UserDTO getEntity() {
		return this.user;
	}
	
}
