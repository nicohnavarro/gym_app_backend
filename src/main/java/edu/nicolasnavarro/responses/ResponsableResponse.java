package edu.nicolasnavarro.responses;

import edu.nicolasnavarro.dao.ResponsableDTO;

public class ResponsableResponse implements EntitiesApplication<ResponsableDTO>{
	
	private ResponsableDTO responsable;
	private String message;
	private int statusCode;
	
	public ResponsableResponse(ResponsableDTO responsable) {
		this.responsable= responsable;
	}
	
	public ResponsableDTO getEntity() {
		return this.responsable;
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

	
}
