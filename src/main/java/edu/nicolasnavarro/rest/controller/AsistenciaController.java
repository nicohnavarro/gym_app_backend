package edu.nicolasnavarro.rest.controller;

import java.util.Date;
import java.util.LinkedList;
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

import edu.nicolasnavarro.dao.AsistenciaDTO;
import edu.nicolasnavarro.dao.repositories.AsistenciaDtoRepository;
import edu.nicolasnavarro.responses.AsistenciaResponse;
import io.swagger.annotations.ApiOperation;

@ApiOperation(value="/api/asistencia",tags ="Asistencia Profile Controller")
@CrossOrigin
@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaController {
	
	@Autowired
	private AsistenciaDtoRepository asistenciaRepository;
	
	@ApiOperation(value="Get All Asistencia", response=Iterable.class)
	@GetMapping(value="getAll")
	public List<AsistenciaDTO> getAllAsistencias(){
		return asistenciaRepository.findAll();
	}
	
	@ApiOperation(value="Get Asistencia by date", response=Iterable.class)
	@GetMapping(value="{date}")
	public List<AsistenciaDTO> getAlumnosByNivel(@PathVariable Date date) {
		List<AsistenciaDTO> listaAsistencia = asistenciaRepository.findAll();
		List<AsistenciaDTO> listaFiltrada = new LinkedList<AsistenciaDTO>();
		try {
			for (AsistenciaDTO asistenciaDTO : listaAsistencia) {
				if(date==asistenciaDTO.getFecha()) {
						listaFiltrada.add(asistenciaDTO);
					}
				}
			return listaFiltrada;
					
		}catch(Exception e) {
			return listaFiltrada;
		}
	}
	
	@ApiOperation(value="Get Asistencia by nivel", response=Iterable.class)
	@GetMapping(value="{nivel}")
	public List<AsistenciaDTO> getAlumnosByNivel(@PathVariable int nivel) {
		List<AsistenciaDTO> listaAsistencia = asistenciaRepository.findAll();
		List<AsistenciaDTO> listaFiltrada = new LinkedList<AsistenciaDTO>();
		try {
			for (AsistenciaDTO asistenciaDTO : listaAsistencia) {
				if(nivel==asistenciaDTO.getNivel_id()) {
						listaFiltrada.add(asistenciaDTO);
					}
				}
			return listaFiltrada;
					
		}catch(Exception e) {
			return listaFiltrada;
		}
	}
	
	@ApiOperation(value="Add Asistencia", response=ResponseEntity.class)
	@PostMapping(value="add")
	public ResponseEntity<AsistenciaResponse> addAsistencia(@RequestBody AsistenciaDTO asistencia){
		AsistenciaResponse ra = null;
		try {
			this.asistenciaRepository.save(asistencia);
			ra = new AsistenciaResponse(asistencia);
			ra.setMessage("Se agrego la asistencia a: "+ asistencia.getAlumno_id());
			ra.setStatusCode(200);
			return ResponseEntity.ok(ra);
		}catch(Exception e) {
			ra= new AsistenciaResponse(null);
			ra.setMessage("No se pudo agregar: "+e.getMessage());
			ra.setStatusCode(300);
			return ResponseEntity.ok(ra);
		}
	}
	

}
