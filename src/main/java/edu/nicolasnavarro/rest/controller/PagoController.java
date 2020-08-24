package edu.nicolasnavarro.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.nicolasnavarro.dao.PagoDTO;
import edu.nicolasnavarro.dao.repositories.PagoDtoRepository;
import io.swagger.annotations.ApiOperation;

@ApiOperation(value="/api/pago",tags ="Pago Profile Controller")
@CrossOrigin
@RestController
@RequestMapping("/api/pago")
public class PagoController {
	
	@Autowired
	private PagoDtoRepository alumnoRepository;
	
	@ApiOperation(value="Get All Pagos", response=Iterable.class)
	@GetMapping(value="getAll")
	public List<PagoDTO> getAllPagos(){
		return alumnoRepository.findAll();
	
	}
}
