package edu.nicolasnavarro.models;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alumno {
	@Id
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
	private Date fechaNacimiento;
	@Column
	private int nroSocio;
	@Column
	private boolean esMenor;
	@Column
	private int edad;
	@Column
	private int responsable_id;
	@Column
	private String certificadoMedico;
	@Column
	private String nivel;
	@Column
	private String categoria;
	@Column
	private String diasPractica;
	
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public int getDni() {
		return dni;
	}
	public String getCorreo() {
		return correo;
	}
	public int getTelefono() {
		return telefono;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public int getNroSocio() {
		return nroSocio;
	}
	public boolean isEsMenor() {
		return esMenor;
	}
	public int getEdad() {
		return edad;
	}
	public int getResponsable_id() {
		return responsable_id;
	}
	public String getCertificadoMedico() {
		return certificadoMedico;
	}
	public String getNivel() {
		return nivel;
	}
	public String getCategoria() {
		return categoria;
	}
	public String getDiasPractica() {
		return diasPractica;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public void setNroSocio(int nroSocio) {
		this.nroSocio = nroSocio;
	}
	public void setEsMenor(boolean esMenor) {
		this.esMenor = esMenor;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setResponsable_id(int responsable_id) {
		this.responsable_id = responsable_id;
	}
	public void setCertificadoMedico(String certificadoMedico) {
		this.certificadoMedico = certificadoMedico;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public void setDiasPractica(String diasPractica) {
		this.diasPractica = diasPractica;
	}

}
