package edu.nicolasnavarro.responses;

import edu.nicolasnavarro.dao.AsistenciaDTO;

public class AsistenciaResponse implements EntitiesApplication<AsistenciaDTO> {

	private AsistenciaDTO asistencia;
	private String message;
	private int statusCode;
	
	
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

	public AsistenciaResponse(AsistenciaDTO asistencia) {
		this.asistencia = asistencia;
	}
	
	public AsistenciaDTO getEntity()
	{
		return this.asistencia;
	}
}
