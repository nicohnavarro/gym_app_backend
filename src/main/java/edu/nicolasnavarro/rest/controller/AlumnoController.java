package edu.nicolasnavarro.rest.controller;

import java.util.LinkedList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.nicolasnavarro.dao.AlumnoDTO;
import edu.nicolasnavarro.dao.UserDTO;
import edu.nicolasnavarro.dao.repositories.AlumnoDtoRepository;
import edu.nicolasnavarro.models.Alumno;
import edu.nicolasnavarro.models.Response;
import edu.nicolasnavarro.models.User;
import edu.nicolasnavarro.responses.AlumnoResponse;
import io.swagger.annotations.ApiOperation;
@ApiOperation(value="/api/alumno",tags ="Alumno Profile Controller")
@CrossOrigin
@RestController
@RequestMapping("/api/alumno")
public class AlumnoController {
	
	@Autowired
	private AlumnoDtoRepository alumnoRepository;
	
	@ApiOperation(value="Get All Alumnos", response=Iterable.class)
	@GetMapping(value="getAll")
	public List<AlumnoDTO> getAllAlumnos(){
		return alumnoRepository.findAll();
	}
	 
	@ApiOperation(value="Get Alumno by Id", response=ResponseEntity.class)
	@GetMapping(value="{id}")
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
	
	@ApiOperation(value="Get Alumnos by Nivel-Cat", response=Iterable.class)
	@GetMapping(value="control/{nivel}/{cat}")
	public List<AlumnoDTO> getAlumnosByNivel(@PathVariable int nivel,@PathVariable int cat) {
		List<AlumnoDTO> listaAlumnos = alumnoRepository.findAll();
		List<AlumnoDTO> listaFiltrada = new LinkedList<AlumnoDTO>();
		try {
			for (AlumnoDTO alumnoDTO : listaAlumnos) {
				if(nivel==0) {
					if(alumnoDTO.getNivel_id()==nivel && alumnoDTO.getCategoria_id()==cat) {
						listaFiltrada.add(alumnoDTO);
					}
				}
				else {
					if(alumnoDTO.getNivel_id()==nivel) {
						listaFiltrada.add(alumnoDTO);
					}
				}
			}
			return listaFiltrada;
					
		}catch(Exception e) {
			return listaFiltrada;
		}
	}
	
	@ApiOperation(value="Add Alumno", response=ResponseEntity.class)
	@PostMapping(value="add")
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
	
	@ApiOperation(value="Update Alumno", response=ResponseEntity.class)
	@PutMapping(value="modify")
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
	
	@ApiOperation(value="Delete Alumno by Id", response=ResponseEntity.class)
	@DeleteMapping(value="delete/{id}")
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
