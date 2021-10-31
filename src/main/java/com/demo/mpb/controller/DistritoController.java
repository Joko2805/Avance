package com.demo.mpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.demo.mpb.model.Distrito;
import com.demo.mpb.service.IDistritoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/distrito")
public class DistritoController {

	@Autowired
	private IDistritoService service;

	@GetMapping(value = "/listar", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Devuelve la lista de los distritos",httpMethod = "GET",nickname = "listarDistritos")
	public ResponseEntity<?> listar(){
		List<Distrito> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping(value = "/registrar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
										produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Registra un nuevo distrito",httpMethod = "POST",nickname = "registrarDistrito")
	public ResponseEntity<?> registrar(@RequestBody Distrito distrito){
		service.registrar(distrito);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/actualizar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
										produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Actualizar la informacion de un distrito",httpMethod = "PUT",nickname = "actualizarDistrito")
	public ResponseEntity<?> actualizar(@RequestBody Distrito distrito){
		Distrito d = service.buscarPorId(distrito.getDistritoId());
		if(d == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.actualizar(distrito);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/eliminar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Elimina un distrito",httpMethod = "DELETE",nickname = "eliminarDistrito")
	public ResponseEntity<?> eliminar(@ApiParam(value = "Identificador del Distrito", required = true)
										@PathVariable(name = "id") Integer id){
		Distrito d = service.buscarPorId(id);
		if(d == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Buscar la informacion de un distrito",httpMethod = "GET",nickname = "buscarDistrito")
	public ResponseEntity<?> buscarPorId(@ApiParam(value = "Identificador del Distrito", required = true)
											@PathVariable(name = "id") Integer id){
		Distrito d = service.buscarPorId(id);
		if(d == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(d,HttpStatus.OK);
	}
}
