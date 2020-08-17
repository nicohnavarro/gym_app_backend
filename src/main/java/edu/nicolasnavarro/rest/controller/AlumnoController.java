package edu.nicolasnavarro.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.nicolasnavarro.dao.AlumnoDTO;
import edu.nicolasnavarro.dao.UserDTO;
import edu.nicolasnavarro.dao.repositories.AlumnoDtoRepository;
import edu.nicolasnavarro.models.Alumno;
import edu.nicolasnavarro.models.Response;
import edu.nicolasnavarro.models.User;
import edu.nicolasnavarro.responses.AlumnoResponse;

@CrossOrigin
@RestController
public class AlumnoController {
	
	@Autowired
	private AlumnoDtoRepository alumnoRepository;
	
	@GetMapping(value="getAllAlumnos")
	public List<AlumnoDTO> getAllAlumnos(){
		return alumnoRepository.findAll();
	}
	 
	
	@GetMapping(value="alumno/{id}")
	public ResponseEntity<AlumnoResponse> getAlumnoById(@PathVariable int id) {
		AlumnoResponse ra = null;
		try {
			ra = new AlumnoResponse(alumnoRepository.findById(id).get());
			ra.setMessage("Alumno encontrado");
			ra.setStatusCode(200);
			return ResponseEntity.ok(ra);			
		}catch(Exception e) {
			ra = new AlumnoResponse(null);
			ra.setMessage(e.getMessage());
			ra.setStatusCode(300);
			return ResponseEntity.ok(ra);
		}
	}
	
	@PostMapping(value="addAlumno")
	public ResponseEntity<AlumnoResponse> addAlumno(@RequestBody AlumnoDTO alumno){
		AlumnoResponse ra = null;
		try {
			this.alumnoRepository.save(alumno);
			ra = new AlumnoResponse(alumno);
			ra.setMessage("Se agrego el alumno: "+ alumno.getApellido());
			ra.setStatusCode(200);
			return ResponseEntity.ok(ra);
		}catch(Exception e) {
			ra= new AlumnoResponse(null);
			ra.setMessage("No se pudo agregar: "+e.getMessage());
			ra.setStatusCode(300);
			return ResponseEntity.ok(ra);
		}
	}
	
	@PutMapping(value="modifyAlumno")
	public ResponseEntity<AlumnoResponse> modifyAlumno(@RequestBody AlumnoDTO alumno){
		AlumnoResponse ra = null;
		try {
			AlumnoDTO amodificar = this.alumnoRepository.findById(alumno.getId()).get();
			amodificar.setNombre(alumno.getNombre());
			amodificar.setCorreo(alumno.getCorreo());
			amodificar.setTelefono(alumno.getTelefono());
			amodificar.setNivel_id(alumno.getNivel_id());
			amodificar.setCategoria_id(alumno.getCategoria_id());
			amodificar.setDias_practica(alumno.getDias_practica());
			this.alumnoRepository.save(amodificar);
			ra = new AlumnoResponse(alumno);
			ra.setMessage("Se modifico correctamente: "+ alumno.getApellido());
			ra.setStatusCode(200);
			return ResponseEntity.ok(ra);
		}catch(Exception e) {
			ra=new AlumnoResponse(null);
			ra.setStatusCode(300);
			ra.setMessage("No se pudo modificar: "+e.getMessage());
			return ResponseEntity.ok(ra);
		}
	}
	
	@DeleteMapping(value="deleteAlumno/{id}")
	public ResponseEntity<AlumnoResponse> deleteAlumno(@PathVariable int id){
		AlumnoResponse ra=null;
		try {
			AlumnoDTO aborrar = this.alumnoRepository.findById(id).get();
			this.alumnoRepository.delete(aborrar);
			ra = new AlumnoResponse(aborrar);
			ra.setMessage("Se elimino correctamente: "+ aborrar.getApellido());
			ra.setStatusCode(200);
			return ResponseEntity.ok(ra);
		}catch(Exception e) {
			ra=new AlumnoResponse(null);
			ra.setStatusCode(300);
			ra.setMessage("No se pudo eliminar: "+e.getMessage());
			return ResponseEntity.ok(ra);
		}
	}
	

}
