package com.demo.mpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.demo.mpb.model.Asignacion;
import com.demo.mpb.service.IAsignacionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/asignacion")
public class AsignacionController {
	
	@Autowired
	private IAsignacionService service;

	@GetMapping(value = "/listar", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Devuelve la lista de las asignaciones",httpMethod = "GET",nickname = "listarAsignaciones")
	public ResponseEntity<?> listar(){
		List<Asignacion> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping(value = "/registrar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
									produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Registra una nueva asignacion",httpMethod = "POST",nickname = "registrarAsignacion")
	public ResponseEntity<?> registrar(@RequestBody Asignacion asignacion){
		service.registrar(asignacion);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/actualizar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
									produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Actualizar la informacion de la asignacion",httpMethod = "PUT",nickname = "actualizarAsignacion")
	public ResponseEntity<?> actualizar(@RequestBody Asignacion asignacion){
		Asignacion a = service.buscarPorId(asignacion.getAsignacionId());
		if(a == null)
			throw new ResponseStatusException(HttpStatus.OK);
		service.actualizar(asignacion);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/eliminar/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Elimina una asignacion",httpMethod = "DELETE",nickname = "eliminarAsignacion")
	public ResponseEntity<?> eliminar(@ApiParam(value = "Identificador de la Asignacion", required = true)
										@PathVariable(name = "id") Integer id){
		Asignacion asignacion = service.buscarPorId(id);
		if(asignacion == null)
			throw new ResponseStatusException(HttpStatus.OK);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscar/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Buscar la informacion de una asignacion",httpMethod = "GET",nickname = "buscarAsignacion")
	public ResponseEntity<?> buscarPorId(@ApiParam(value = "Identificador de la asignacion", required = true)
											@PathVariable(name = "id") Integer id){
		Asignacion asignacion = service.buscarPorId(id);
		if(asignacion == null)
			throw new ResponseStatusException(HttpStatus.OK);
		return new ResponseEntity<>(asignacion,HttpStatus.OK);
	}
}
