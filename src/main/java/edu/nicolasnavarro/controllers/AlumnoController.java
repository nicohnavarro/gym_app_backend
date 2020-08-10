package edu.nicolasnavarro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.nicolasnavarro.models.Alumno;

@RestController
public class AlumnoController {
	
	@Autowired
	private Alumno alumno;

	@GetMapping(value="alumno")
	public Alumno getPersona() {
		alumno.setNombre("Nicolas");
		alumno.setEdad(14);
		return alumno;
	}
}
