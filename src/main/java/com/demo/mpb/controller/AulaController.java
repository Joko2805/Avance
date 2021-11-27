package com.demo.mpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.demo.mpb.model.Aula;
import com.demo.mpb.service.IAulaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/aula")
public class AulaController {

	@Autowired
	private IAulaService service;
	
	@GetMapping(value = "/listar", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Devuelve la lista de las aulas",httpMethod = "GET",nickname = "listarAulas")
	public ResponseEntity<?> listar(){
		List<Aula> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping(value = "/registrar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
										produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Registra una nueva aula",httpMethod = "POST",nickname = "registrarAula")
	public ResponseEntity<?> registrar(@RequestBody Aula aula){
		service.registrar(aula);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/actualizar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
										produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Actualizar la informacion de una aula",httpMethod = "PUT",nickname = "actualizarAula")
	public ResponseEntity<?> actualizar(@RequestBody Aula aula){
		Aula a = service.buscarPorId(aula.getAulaId());
		if(a == null)
			throw new ResponseStatusException(HttpStatus.OK);
		service.actualizar(aula);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/eliminar/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Elimina un aula",httpMethod = "DELETE",nickname = "eliminarAula")
	public ResponseEntity<?> eliminar(@ApiParam(value = "Identificador de un aula", required = true)
										@PathVariable(name = "id") Integer id){
		Aula aula= service.buscarPorId(id);
		if(aula == null)
			throw new ResponseStatusException(HttpStatus.OK);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscar/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Buscar la informacion de una aula",httpMethod = "GET",nickname = "buscarAula")
	public ResponseEntity<?> buscarPorId(@ApiParam(value = "Identificador del aula", required = true)
											@PathVariable(name = "id") Integer id){
		Aula aula = service.buscarPorId(id);
		if(aula == null)
			throw new ResponseStatusException(HttpStatus.OK);
		return new ResponseEntity<>(aula,HttpStatus.OK);
	}
}
