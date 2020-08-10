package edu.nicolasnavarro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.nicolasnavarro.models.Alumno;
import edu.nicolasnavarro.repositories.AlumnoRepository;

@RestController
public class AlumnoController {
	
	//@Autowired
	//private Alumno alumno;

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	
//	  @GetMapping(value="alumno") public Alumno getPersona() {
//	  alumno.setNombre("Nicolas"); alumno.setEdad(14); return alumno; }
//	 
	
	@GetMapping(value="getAllAlumnos")
	public List<Alumno> getAllAlumnos(){
		return alumnoRepository.findAll();
	}
}
