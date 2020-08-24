package edu.nicolasnavarro.models;

import javax.persistence.Column;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;

@Component
@ApiModel(description="Pago Model")
public class Pago {
	
	private int alumno_id;
	private int pago;
	private int estado;
	public int getAlumno_id() {
		return alumno_id;
	}
	public void setAlumno_id(int alumno_id) {
		this.alumno_id = alumno_id;
	}
	public int getPago() {
		return pago;
	}
	public void setPago(int pago) {
		this.pago = pago;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	

}
