package edu.nicolasnavarro.models;

import org.springframework.stereotype.Component;

@Component
public class User {

	private String correo;
	private String clave;
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
}
