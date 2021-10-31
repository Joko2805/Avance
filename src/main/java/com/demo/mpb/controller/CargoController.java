package com.demo.mpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.demo.mpb.model.Cargo;
import com.demo.mpb.service.ICargoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/cargo")
public class CargoController {

	@Autowired
	private ICargoService service;

	@GetMapping(value = "/listar", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Devuelve la lista de los cargos",httpMethod = "GET",nickname = "listarCargos")
	public ResponseEntity<?> listar(){
		List<Cargo> lista = service.listar();		
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping(value = "/registrar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
										produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Registra un nuevo cargo",httpMethod = "POST",nickname = "registrarCargo")
	public ResponseEntity<?> registrar(@RequestBody Cargo cargo){
		service.registrar(cargo);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/actualizar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
										produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Actualizar la informacion de un cargo",httpMethod = "PUT",nickname = "actualizarCargo")
	public ResponseEntity<?> actualizar(@RequestBody Cargo cargo){
		Cargo c = service.buscarPorId(cargo.getCargoId());
		if(c == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.actualizar(cargo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/eliminar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Elimina un cargo",httpMethod = "DELETE",nickname = "eliminarCargo")
	public ResponseEntity<?> eliminar(@ApiParam(value = "Identificador del Cargo", required = true)
										@PathVariable(name = "id") Integer id){
		Cargo c = service.buscarPorId(id);
		if(c == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Buscar la informacion de un cargo",httpMethod = "GET",nickname = "buscarCargo")
	public ResponseEntity<?> buscarPorId(@ApiParam(value = "Identificador del Cargo", required = true)
											@PathVariable(name = "id") Integer id){
		Cargo cargo = service.buscarPorId(id);
		if(cargo == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(cargo,HttpStatus.OK);
	}
}
