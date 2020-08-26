package edu.nicolasnavarro.dao;

import java.util.Date;

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
	@ApiModelProperty(notes="ID del Pago", name="idPago", required = true, value="123")
	private int id;
	
	@Column
	private int alumno_id;
	
	@Column
	private int monto;

	@Column
	private Date fecha;

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
