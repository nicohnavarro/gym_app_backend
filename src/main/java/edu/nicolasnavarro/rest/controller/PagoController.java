package edu.nicolasnavarro.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.nicolasnavarro.dao.AlumnoDTO;
import edu.nicolasnavarro.dao.PagoDTO;
import edu.nicolasnavarro.dao.repositories.PagoDtoRepository;
import edu.nicolasnavarro.responses.AlumnoResponse;
import edu.nicolasnavarro.responses.PagoResponse;
import io.swagger.annotations.ApiOperation;

@ApiOperation(value="/api/pago",tags ="Pago Profile Controller")
@CrossOrigin
@RestController
@RequestMapping("/api/pago")
public class PagoController {
	
	@Autowired
	private PagoDtoRepository pagoRepository;
	
	@ApiOperation(value="Get All Pagos", response=Iterable.class)
	@GetMapping(value="getAll")
	public List<PagoDTO> getAllPagos(){
		return pagoRepository.findAll();
	
	}
	
	@ApiOperation(value="Get Pago by Id", response=ResponseEntity.class)
	@GetMapping(value="{id}")
	public ResponseEntity<PagoResponse> getPagoById(@PathVariable int id) {
		PagoResponse rp = null;
		try {
			rp = new PagoResponse(pagoRepository.findById(id).get());
			rp.setMessage("Pago encontrado");
			rp.setStatusCode(200);
			return ResponseEntity.ok(rp);			
		}catch(Exception e) {
			rp = new PagoResponse(null);
			rp.setMessage("No encontrado: "+e.getMessage());
			rp.setStatusCode(300);
			return ResponseEntity.ok(rp);
		}
	}
	
	@ApiOperation(value="Add Pago", response=ResponseEntity.class)
	@PostMapping(value="add")
	public ResponseEntity<PagoResponse> addPago(@RequestBody PagoDTO pago){
		PagoResponse rp = null;
		try {
			this.pagoRepository.save(pago);
			rp = new PagoResponse(pago);
			rp.setMessage("Se agrego el pago: "+ pago.getId());
			rp.setStatusCode(200);
			return ResponseEntity.ok(rp);
		}catch(Exception e) {
			rp= new PagoResponse(null);
			rp.setMessage("No se pudo pagar: "+e.getMessage());
			rp.setStatusCode(300);
			return ResponseEntity.ok(rp);
		}
	}
	
}
