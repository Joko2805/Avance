package com.demo.mpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.demo.mpb.model.Curso;
import com.demo.mpb.service.ICursoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private ICursoService service;

	@GetMapping(value = "/listar", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Devuelve la lista de los cursos",httpMethod = "GET",nickname = "listarCurso")
	public ResponseEntity<?> listar(){
		List<Curso> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping(value = "/registrar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
										produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Registra un nuevo curso",httpMethod = "POST",nickname = "registrarCurso")
	public ResponseEntity<?> registrar(@RequestBody Curso curso){
		service.registrar(curso);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/actualizar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
										produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Actualizar la informacion de un curso",httpMethod = "PUT",nickname = "actualizarCurso")
	public ResponseEntity<?> actualizar(@RequestBody Curso curso){
		Curso c = service.buscarPorId(curso.getCursoId());
		if(c == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.actualizar(curso);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/eliminar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Elimina un curso",httpMethod = "DELETE",nickname = "eliminarCurso")
	public ResponseEntity<?> eliminar(@ApiParam(value = "Identificador del Curso", required = true)
										@PathVariable(name = "id") Integer id){
		Curso curso = service.buscarPorId(id);
		if(curso == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Buscar la informacion de un curso",httpMethod = "GET",nickname = "buscarCurso")
	public ResponseEntity<?> buscarPorId(@ApiParam(value = "Identificador del Curso", required = true)
											@PathVariable(name = "id") Integer id){
		Curso curso = service.buscarPorId(id);
		if(curso == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(curso,HttpStatus.OK);
	}
}
