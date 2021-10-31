package com.demo.mpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.demo.mpb.model.Trabajador;
import com.demo.mpb.service.ITrabajadorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/trabajador")
public class TrabajadorController {

	@Autowired
	private ITrabajadorService service;

	@GetMapping(value = "/listar", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Devuelve la lista de los trabajadores",httpMethod = "GET",nickname = "listarTrabajadores")
	public ResponseEntity<?> listar(){
		List<Trabajador> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping(value = "/registrar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
										produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Registra un nuevo trabajador",httpMethod = "POST",nickname = "registrarTrabajador")
	public ResponseEntity<?> registrar(@RequestBody Trabajador trabajador){
		service.registrar(trabajador);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/actualizar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
										produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Actualizar la informacion de un trabajador",httpMethod = "PUT",nickname = "actualizarTrabajador")
	public ResponseEntity<?> actualizar(@RequestBody Trabajador trabajador){
		Trabajador t = service.buscarPorId(trabajador.getTrabajadorId());
		if(t == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.actualizar(trabajador);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/eliminar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Elimina un trabajador",httpMethod = "DELETE",nickname = "eliminarTrabajador")
	public ResponseEntity<?> eliminar(@ApiParam(value = "Identificador del Trabajador", required = true)
										@PathVariable(name = "id") Integer id){
		Trabajador trabajador = service.buscarPorId(id);
		if(trabajador == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Buscar la informacion de un trabajador",httpMethod = "GET",nickname = "buscarTrabajador")
	public ResponseEntity<?> buscarPorId(@ApiParam(value = "Identificador del Trabajador", required = true)
											@PathVariable(name = "id") Integer id){
		Trabajador trabajador = service.buscarPorId(id);
		if(trabajador == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(trabajador,HttpStatus.OK);
	}
}
