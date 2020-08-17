package edu.nicolasnavarro.responses;

import edu.nicolasnavarro.dao.AlumnoDTO;

public class AlumnoResponse implements EntitiesApplication<AlumnoDTO> {
	
	private AlumnoDTO alumno;
	private String message;
	private int statusCode;
	
	public AlumnoResponse(AlumnoDTO alumno) {
		this.alumno=alumno;
	}
	
	
	
	public AlumnoDTO getAlumno() {
		return alumno;
	}



	public void setAlumno(AlumnoDTO alumno) {
		this.alumno = alumno;
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



	public AlumnoDTO getEntity() {
		return this.alumno;
	}

}
