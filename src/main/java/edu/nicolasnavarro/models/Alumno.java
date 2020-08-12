package edu.nicolasnavarro.models;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class Alumno {
	private int id;
	private String nombre;
	private String apellido;
	private int dni;
	private String correo;
	private int telefono;
	private Date fecha_nacimiento;
	private int nro_socio;
	private int edad;
	private int responsable_id;
	private String certificado_medico;
	private String nivel;
	private String categoria;
	private String dias_practica;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getResponsable_id() {
		return responsable_id;
	}
	public void setResponsable_id(int responsable_id) {
		this.responsable_id = responsable_id;
	}
	public String getCertificado_medico() {
		return certificado_medico;
	}
	public void setCertificado_medico(String certificado_medico) {
		this.certificado_medico = certificado_medico;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDias_practica() {
		return dias_practica;
	}
	public void setDias_practica(String dias_practica) {
		this.dias_practica = dias_practica;
	}
	
	
}
