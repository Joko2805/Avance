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

import com.demo.mpb.model.Alumno;
import com.demo.mpb.model.Matricula;
import com.demo.mpb.service.IMatriculaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {
	
	@Autowired
	private IMatriculaService service;
	
	@GetMapping(value = "/listar", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Devuelve la lista de las matriculas",httpMethod = "GET",nickname = "listarMatriculas")
	public ResponseEntity<?> listar(){
		List<Matricula> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping(value = "/registrar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
									produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Registra una nueva matricula",httpMethod = "POST",nickname = "registrarMatricula")
	public ResponseEntity<?> registrar(@RequestBody Matricula matricula){
		service.registrar(matricula);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/actualizar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
									produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Actualizar la informacion de una matricula",httpMethod = "PUT",nickname = "actualizarMatricula")
	public ResponseEntity<?> actualizar(@RequestBody Matricula matricula){
		Matricula m = service.buscarPorId(matricula.getMatriculaId());
		if(m == null)
			throw new ResponseStatusException(HttpStatus.OK);
		service.actualizar(matricula);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/eliminar/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Elimina una matricula",httpMethod = "DELETE",nickname = "eliminarMatricula")
	public ResponseEntity<?> eliminar(@ApiParam(value = "Identificador de la matricula", required = true)
										@PathVariable(name = "id") Integer id){
		Matricula matricula = service.buscarPorId(id);
		if(matricula == null)
			throw new ResponseStatusException(HttpStatus.OK);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscar/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Buscar la informacion de una matricula",httpMethod = "GET",nickname = "buscarMatricula")
	public ResponseEntity<?> buscarPorId(@ApiParam(value = "Identificador de la Matricula", required = true)
											@PathVariable(name = "id") Integer id){
		Matricula matricula = service.buscarPorId(id);
		if(matricula == null)
			throw new ResponseStatusException(HttpStatus.OK);
		return new ResponseEntity<>(matricula,HttpStatus.OK);
	}
	
	@GetMapping(value = "/find/{username}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Buscar un matricula por el nombre de usuario",httpMethod = "GET",nickname = "buscarPorNombreUsuarioMatricula")
	public ResponseEntity<?> findByUsername(@ApiParam(value = "Nombre de usuario del Alumno", required = true) 
												@PathVariable(name = "username") String username){
		Matricula matricula = service.buscarPorNombreUsuario(username);
		if(matricula == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(matricula,HttpStatus.OK);
	}

}
