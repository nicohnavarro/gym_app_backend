package edu.nicolasnavarro.dao;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="alumnos")
public class AlumnoDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	private int responsable_id;
	@Column
	private String certificado_medico;
	@Column
	private String nivel;
	@Column
	private String categoria;
	@Column
	private String dias_practica;
	
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
		return fecha_nacimiento;
	}
	public int getNroSocio() {
		return nro_socio;
	}
	public int getEdad() {
		return edad;
	}
	public int getResponsable_id() {
		return responsable_id;
	}
	public String getCertificadoMedico() {
		return certificado_medico;
	}
	public String getNivel() {
		return nivel;
	}
	public String getCategoria() {
		return categoria;
	}
	public String getDiasPractica() {
		return dias_practica;
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
		this.fecha_nacimiento = fechaNacimiento;
	}
	public void setNroSocio(int nroSocio) {
		this.nro_socio = nroSocio;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setResponsable_id(int responsable_id) {
		this.responsable_id = responsable_id;
	}
	public void setCertificadoMedico(String certificadoMedico) {
		this.certificado_medico = certificadoMedico;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public void setDiasPractica(String diasPractica) {
		this.dias_practica = diasPractica;
	}

}
