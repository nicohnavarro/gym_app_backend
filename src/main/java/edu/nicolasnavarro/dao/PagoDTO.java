package edu.nicolasnavarro.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="pagos")
@ApiModel(description="Pago Model")
public class PagoDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@ApiModelProperty(notes="ID del Pago", name="id", required = true, value="123")
	private int id;
	
	@Column
	private int alumno_id;
	
	@Column
	private int pago;

	@Column
	private int estado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
