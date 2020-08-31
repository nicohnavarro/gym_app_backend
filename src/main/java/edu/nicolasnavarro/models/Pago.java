package edu.nicolasnavarro.models;

import java.util.Date;

import javax.persistence.Column;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;

@Component
@ApiModel(description="Pago Model")
public class Pago {
	
	private int alumno_id;
	private int nivel_id;
	private int monto;
	private Date fecha;
	
	public int getNivel_id() {
		return nivel_id;
	}
	public void setNivel_id(int nivel_id) {
		this.nivel_id = nivel_id;
	}
	public int getAlumno_id() {
		return alumno_id;
	}
	public void setAlumno_id(int alumno_id) {
		this.alumno_id = alumno_id;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
