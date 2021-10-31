package com.demo.mpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.demo.mpb.model.Seccion;
import com.demo.mpb.service.ISeccionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/seccion")
public class SeccionController {

	@Autowired
	private ISeccionService service;

	@GetMapping(value = "/listar", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Devuelve la lista de las seccion",httpMethod = "GET",nickname = "listarSeccion")
	public ResponseEntity<?> listar(){
		List<Seccion> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping(value = "/registrar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
										produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Registra un nueva seccion",httpMethod = "POST",nickname = "registrarSeccion")
	public ResponseEntity<?> registrar(@RequestBody Seccion seccion){
		service.registrar(seccion);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/actualizar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
										produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Actualizar la informacion de una seccion",httpMethod = "PUT",nickname = "actualizarSeccion")
	public ResponseEntity<?> actualizar(@RequestBody Seccion seccion){
		Seccion s = service.buscarPorId(seccion.getSeccionId());
		if(s == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.actualizar(seccion);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/eliminar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Elimina una seccion",httpMethod = "DELETE",nickname = "eliminarSeccion")
	public ResponseEntity<?> eliminar(@ApiParam(value = "Identificador de la Seccion", required = true)
										@PathVariable(name = "id") Integer id){
		Seccion seccion = service.buscarPorId(id);
		if(seccion == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Buscar la informacion de una seccion",httpMethod = "GET",nickname = "buscarSeccion")
	public ResponseEntity<?> buscarPorId(@ApiParam(value = "Identificador de la Seccion", required = true)
											@PathVariable(name = "id") Integer id){
		Seccion seccion = service.buscarPorId(id);
		if(seccion == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(seccion,HttpStatus.OK);
	}
}
