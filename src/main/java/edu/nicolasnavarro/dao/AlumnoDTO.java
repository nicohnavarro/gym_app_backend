package edu.nicolasnavarro.dao;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="alumnos")
@ApiModel(description="Alumno Model")
public class AlumnoDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@ApiModelProperty(notes="ID del Alumno", name="id", required = true, value="123")
	private int id;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private int dni;
	@Column
	private String correo;
	@Column
	private int telefono;
	@Column
	private Date fecha_nacimiento;
	@Column
	private int nro_socio;
	@Column
	private int edad;
	@Column
	@Nullable
	private Integer responsable_id;
	@Column
	private String certificado_medico;
	@Column
	private int nivel_id;
	@Column
	private int categoria_id;
	@Column
	private String dias_practica;
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public int getNro_socio() {
		return nro_socio;
	}
	public void setNro_socio(int nro_socio) {
		this.nro_socio = nro_socio;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Integer getResponsable_id() {
		return responsable_id;
	}
	public void setResponsable_id(Integer responsable_id) {
		this.responsable_id = responsable_id;
	}
	public String getCertificado_medico() {
		return certificado_medico;
	}
	public void setCertificado_medico(String certificado_medico) {
		this.certificado_medico = certificado_medico;
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
	public String getDias_practica() {
		return dias_practica;
	}
	public void setDias_practica(String dias_practica) {
		this.dias_practica = dias_practica;
	}
	
	

}
