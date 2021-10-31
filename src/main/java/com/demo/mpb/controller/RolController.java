package com.demo.mpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.demo.mpb.model.Rol;
import com.demo.mpb.service.IRolService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/rol")
public class RolController {

	@Autowired
	private IRolService service;

	@GetMapping(value = "/listar", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Devuelve la lista de los roles",httpMethod = "GET",nickname = "listarRoles")
	public ResponseEntity<?> listar(){
		List<Rol> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping(value = "/registrar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
										produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Registra un nuevo rol",httpMethod = "POST",nickname = "registrarRoles")
	public ResponseEntity<?> registrar(@RequestBody Rol rol){
		service.registrar(rol);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/actualizar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
										produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Actualizar la informacion de un rol",httpMethod = "PUT",nickname = "actualizarRoles")
	public ResponseEntity<?> actualizar(@RequestBody Rol rol){
		Rol r = service.buscarPorId(rol.getRolId());
		if(r == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.actualizar(rol);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/eliminar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Elimina un rol",httpMethod = "DELETE",nickname = "eliminarRol")
	public ResponseEntity<?> eliminar(@ApiParam(value = "Identificador del Rol", required = true)
										@PathVariable(name = "id") Integer id){
		Rol rol = service.buscarPorId(id);
		if(rol == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Buscar la informacion de un rol",httpMethod = "GET",nickname = "buscarRol")
	public ResponseEntity<?> buscarPorId(@ApiParam(value = "Identificador del Rol", required = true)
											@PathVariable(name = "id") Integer id){
		Rol rol = service.buscarPorId(id);
		if(rol == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(rol,HttpStatus.OK);
	}
}
