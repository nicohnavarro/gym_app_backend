package edu.nicolasnavarro.models;

import java.util.Date;


import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;

@Component
@ApiModel(description="Asistencia Model")
public class Asistencia {

	private Date fecha;
	private int nivel_id;
	private int categoria_id;
	private int alumno_id;
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getNivel_id() {
		return nivel_id;
	}
	public void setNivel_id(int nivel_id) {
		this.nivel_id = nivel_id;
	}
	public int getCategoria_id() {
		return categoria_id;
	}
	public void setCategoria_id(int categoria_id) {
		this.categoria_id = categoria_id;
	}
	public int getAlumno_id() {
		return alumno_id;
	}
	public void setAlumno_id(int alumno_id) {
		this.alumno_id = alumno_id;
	}
	
}
