package com.demo.mpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.demo.mpb.model.Calificacion;
import com.demo.mpb.service.ICalificacionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/calificacion")
public class CalificacionController {

	@Autowired
	private ICalificacionService service;
	
	@GetMapping(value = "/listar", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Devuelve la lista de las calificaciones",httpMethod = "GET",nickname = "listarCalificaciones")
	public ResponseEntity<?> listar(){
		List<Calificacion> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping(value = "/registrar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
									produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Registra un nuevo alumno",httpMethod = "POST",nickname = "registrarCalificaciones")
	public ResponseEntity<?> registrar(@RequestBody Calificacion calificacion){
		service.registrar(calificacion);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/actualizar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
									produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Actualizar la informacion de una calificacion",httpMethod = "PUT",nickname = "actualizarCalificacion")
	public ResponseEntity<?> actualizar(@RequestBody Calificacion calificacion){
		Calificacion c = service.buscarPorId(calificacion.getCalificacionId());
		if(c == null)
			throw new ResponseStatusException(HttpStatus.OK);
		service.actualizar(calificacion);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/eliminar/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Elimina una calificacion",httpMethod = "DELETE",nickname = "eliminarCalificacion")
	public ResponseEntity<?> eliminar(@ApiParam(value = "Identificador de la calificacion", required = true)
										@PathVariable(name = "id") Integer id){
		Calificacion calificacion = service.buscarPorId(id);
		if(calificacion == null)
			throw new ResponseStatusException(HttpStatus.OK);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscar/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Buscar la informacion de una calificacion",httpMethod = "GET",nickname = "buscarCalificacion")
	public ResponseEntity<?> buscarPorId(@ApiParam(value = "Identificador de la calificacion", required = true)
											@PathVariable(name = "id") Integer id){
		Calificacion calificacion = service.buscarPorId(id);
		if(calificacion == null)
			throw new ResponseStatusException(HttpStatus.OK);
		return new ResponseEntity<>(calificacion,HttpStatus.OK);
	}

}
