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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.nicolasnavarro.dao.ResponsableDTO;
import edu.nicolasnavarro.dao.repositories.ResponsableDtoRepository;
import edu.nicolasnavarro.responses.ResponsableResponse;
import io.swagger.annotations.ApiOperation;

@ApiOperation(value="/api/responsable",tags ="Responsable Profile Controller")
@CrossOrigin
@RestController
@RequestMapping("/api/responsable")
public class ResponsableController {

	@Autowired
	private ResponsableDtoRepository responsableRepo;
	
	@ApiOperation(value="Get All Responsables", response=Iterable.class)
	@GetMapping(value="getAll")
	public List<ResponsableDTO> getAllResponsables(){
		return responsableRepo.findAll();
	}
	
	@ApiOperation(value="Get Responsable by Id", response=ResponseEntity.class)
	@GetMapping(value="/{id}")
	public ResponseEntity<ResponsableResponse> getResponsableById(@PathVariable int id){
		ResponsableResponse rr = null;
		try {
			rr=new ResponsableResponse(responsableRepo.findById(id).get());
			rr.setMessage("Responsable encontrado");
			rr.setStatusCode(200);
			return ResponseEntity.ok(rr);
			
		}catch(Exception e) {
			rr=new ResponsableResponse(null);
			rr.setMessage(e.getMessage());
			rr.setStatusCode(300);
			return ResponseEntity.ok(rr);
		}
	}
	
	@ApiOperation(value="Add Alumno", response=ResponseEntity.class)
	@PostMapping(value="add")
	public ResponseEntity<ResponsableResponse> addResponsable(@RequestBody ResponsableDTO responsable){
		ResponsableResponse rr = null;
		try {
			this.responsableRepo.save(responsable);
			rr = new ResponsableResponse(responsable);
			rr.setMessage("Se agrego el responsable: "+ responsable.getApellido());
			rr.setStatusCode(200);
			return ResponseEntity.ok(rr);
		}catch(Exception e) {
			rr= new ResponsableResponse(null);
			rr.setMessage("No se pudo agregar: "+e.getMessage());
			rr.setStatusCode(300);
			return ResponseEntity.ok(rr);
		}
	}
	
	@ApiOperation(value="Update Alumno", response=ResponseEntity.class)
	@PutMapping(value="modify")
	public ResponseEntity<ResponsableResponse> modifyResponsable(@RequestBody ResponsableDTO responsable){
		ResponsableResponse rr = null;
		try {
			ResponsableDTO rmodificar = this.responsableRepo.findById(responsable.getId()).get();
			rmodificar.setNombre(responsable.getNombre());
			this.responsableRepo.save(rmodificar);
			rr = new ResponsableResponse(responsable);
			rr.setMessage("Se modifico correctamente: "+ responsable.getApellido());
			rr.setStatusCode(200);
			return ResponseEntity.ok(rr);
		}catch(Exception e) {
			rr=new ResponsableResponse(null);
			rr.setStatusCode(300);
			rr.setMessage("No se pudo modificar: "+e.getMessage());
			return ResponseEntity.ok(rr);
		}
	}
	
	@ApiOperation(value="Delete Alumno by Id", response=ResponseEntity.class)
	@DeleteMapping(value="delete")
	public ResponseEntity<ResponsableResponse> deleteResponsable(@PathVariable int id){
		ResponsableResponse rr=null;
		try {
			ResponsableDTO rborrar = this.responsableRepo.findById(id).get();
			this.responsableRepo.delete(rborrar);
			rr = new ResponsableResponse(rborrar);
			rr.setMessage("Se elimino correctamente: "+ rborrar.getApellido());
			rr.setStatusCode(200);
			return ResponseEntity.ok(rr);
		}catch(Exception e) {
			rr=new ResponsableResponse(null);
			rr.setStatusCode(300);
			rr.setMessage("No se pudo eliminar: "+e.getMessage());
			return ResponseEntity.ok(rr);
		}
	}
}
