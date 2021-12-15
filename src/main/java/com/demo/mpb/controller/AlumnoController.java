package com.demo.mpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.demo.mpb.model.Alumno;
import com.demo.mpb.service.IAlumnoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
	
	@Autowired
	private IAlumnoService service;

	@GetMapping(value = "/listar", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Devuelve la lista de los alumnos",httpMethod = "GET",nickname = "listarAlumnos")
	public ResponseEntity<?> listar(){
		List<Alumno> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping(value = "/registrar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
									produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Registra un nuevo alumno",httpMethod = "POST",nickname = "registrarAlumno")
	public ResponseEntity<?> registrar(@RequestBody Alumno alumno){
		service.registrar(alumno);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/actualizar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
									produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Actualizar la informacion de un alumno",httpMethod = "PUT",nickname = "actualizarAlumno")
	public ResponseEntity<?> actualizar(@RequestBody Alumno alumno){
		Alumno a = service.buscarPorId(alumno.getAlumnoId());
		if(a == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.actualizar(alumno);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/eliminar/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Elimina un alumno",httpMethod = "DELETE",nickname = "eliminarAlumno")
	public ResponseEntity<?> eliminar(@ApiParam(value = "Identificador del Alumno", required = true)
										@PathVariable(name = "id") Integer id){
		Alumno alumno = service.buscarPorId(id);
		if(alumno == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscar/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Buscar la informacion de un alumno",httpMethod = "GET",nickname = "buscarAlumno")
	public ResponseEntity<?> buscarPorId(@ApiParam(value = "Identificador del Alumno", required = true)
											@PathVariable(name = "id") Integer id){
		Alumno alumno = service.buscarPorId(id);
		if(alumno == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(alumno,HttpStatus.OK);
	}
	
	@GetMapping(value = "/find/{username}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Buscar un alumno por el nombre de usuario",httpMethod = "GET",nickname = "buscarPorNombreUsuario")
	public ResponseEntity<?> findByUsername(@ApiParam(value = "Nombre de usuario del Alumno", required = true) 
												@PathVariable(name = "username") String username){
		Alumno alumno = service.buscarPorNombreUsuario(username);
		if(alumno == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(alumno,HttpStatus.OK);
	}
}
