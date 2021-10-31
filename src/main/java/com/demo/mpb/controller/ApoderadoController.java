package com.demo.mpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.demo.mpb.model.Apoderado;
import com.demo.mpb.service.IApoderadoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/apoderado")
public class ApoderadoController {

	@Autowired
	private IApoderadoService service;

	@GetMapping(value = "/listar", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Devuelve la lista de los apoderados",httpMethod = "GET",nickname = "listarApoderado")
	public ResponseEntity<?> listar(){
		List<Apoderado> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping(value = "/registrar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
										produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Registra un nuevo apoderado",httpMethod = "POST",nickname = "registrarApoderado")
	public ResponseEntity<?> registrar(@RequestBody Apoderado apoderado){
		service.registrar(apoderado);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/actualizar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
										produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Actualizar la informacion de un apoderado",httpMethod = "PUT",nickname = "actualizarApoderado")
	public ResponseEntity<?> actualizar(@RequestBody Apoderado apoderado){
		Apoderado a = service.buscarPorId(apoderado.getApoderadoId());
		if(a == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.actualizar(apoderado);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/eliminar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Elimina un apoderado",httpMethod = "DELETE",nickname = "eliminarApoderado")
	public ResponseEntity<?> eliminar(@ApiParam(value = "Identificador del Apoderado", required = true)
										@PathVariable(name = "id") Integer id){
		Apoderado apoderado = service.buscarPorId(id);
		if(apoderado == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Buscar la informacion de un apoderado",httpMethod = "GET",nickname = "buscarApoderado")
	public ResponseEntity<?> buscarPorId(@ApiParam(value = "Identificador del Apoderado", required = true)
											@PathVariable(name = "id") Integer id){
		Apoderado apoderado = service.buscarPorId(id);
		if(apoderado == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(apoderado,HttpStatus.OK);
	}

}
