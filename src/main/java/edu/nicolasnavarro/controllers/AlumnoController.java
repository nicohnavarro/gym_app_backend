package edu.nicolasnavarro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.nicolasnavarro.dtos.AlumnoDTO;
import edu.nicolasnavarro.models.Response;
import edu.nicolasnavarro.repositories.AlumnoRepository;
@CrossOrigin
@RestController
public class AlumnoController {
	
	//@Autowired
	//private Alumno alumno;

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private Response respuesta;
	
//	  @GetMapping(value="alumno") public Alumno getPersona() {
//	  alumno.setNombre("Nicolas"); alumno.setEdad(14); return alumno; }
//	 
	
	@GetMapping(value="getAllAlumnos")
	public List<AlumnoDTO> getAllAlumnos(){
		return alumnoRepository.findAll();
	}
	
	@GetMapping(value="alumno/{id}")
	public AlumnoDTO getAlumnoById(@PathVariable int id) {
		return this.alumnoRepository.findById(id).get();
	}
	
	@PostMapping(value="saveAlumno")
	public ResponseEntity<Response> saveAlumno(@RequestBody AlumnoDTO alumno){
		try {
			this.alumnoRepository.save(alumno);
			this.respuesta.setMensaje("Se agrego correctamente");
			this.respuesta.setStatusCode(200);		
		}catch(Exception e) {
			this.respuesta.setMensaje("No se inserto correctamente");
			this.respuesta.setStatusCode(500);
			this.respuesta.setError(e.getMessage());
		}
		
		return ResponseEntity.ok(this.respuesta);
	}
	
	@PutMapping(value="modifyAlumno")
	public ResponseEntity<Response> modifyAlumno(@RequestBody AlumnoDTO alumno){
		try {
			AlumnoDTO amodificar = this.alumnoRepository.findById(alumno.getId()).get();
			amodificar.setNombre(alumno.getNombre());
			this.alumnoRepository.save(amodificar);
			this.respuesta.setMensaje("Se modifico correctamente");
			this.respuesta.setStatusCode(200);		
		}catch(Exception e) {
			this.respuesta.setMensaje("No se inserto correctamente");
			this.respuesta.setStatusCode(500);
			this.respuesta.setError(e.getMessage());
		}
		return ResponseEntity.ok(this.respuesta);
	}
}
