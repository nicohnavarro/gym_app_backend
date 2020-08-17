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

import edu.nicolasnavarro.dao.ResponsableDTO;
import edu.nicolasnavarro.dao.repositories.ResponsableDtoRepository;
import edu.nicolasnavarro.responses.ResponsableResponse;

@CrossOrigin
@RestController
public class ResponsableController {

	@Autowired
	private ResponsableDtoRepository responsableRepo;
	
	@GetMapping(value="getAllResponsables")
	public List<ResponsableDTO> getAllResponsables(){
		return responsableRepo.findAll();
	}
	
	@GetMapping(value="responsable/{id}")
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
	
	@PostMapping(value="addResponsable")
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
	
	@PutMapping(value="modifyResponsable")
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
	
	@DeleteMapping(value="deleteResponsable")
	public ResponseEntity<ResponsableResponse> deleteResponsable(@RequestBody ResponsableDTO responsable){
		ResponsableResponse rr=null;
		try {
			ResponsableDTO rborrar = this.responsableRepo.findById(responsable.getId()).get();
			this.responsableRepo.delete(rborrar);
			rr = new ResponsableResponse(responsable);
			rr.setMessage("Se elimino correctamente: "+ responsable.getApellido());
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
