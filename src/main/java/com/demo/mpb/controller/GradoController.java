package com.demo.mpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.demo.mpb.model.Grado;
import com.demo.mpb.service.IGradoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/grado")
public class GradoController {

	@Autowired
	private IGradoService service;

	@GetMapping(value = "/listar", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Devuelve la lista de los grados",httpMethod = "GET",nickname = "listarGrados")
	public ResponseEntity<?> listar(){
		List<Grado> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping(value = "/registrar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
										produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Registra un nuevo grado",httpMethod = "POST",nickname = "registrarGrado")
	public ResponseEntity<?> registrar(@RequestBody Grado grado){
		service.registrar(grado);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/actualizar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
										produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Actualizar la informacion de un grado",httpMethod = "PUT",nickname = "actualizarGrado")
	public ResponseEntity<?> actualizar(@RequestBody Grado grado){
		Grado g = service.buscarPorId(grado.getGradoId());
		if(g == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.actualizar(grado);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/eliminar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Elimina un grado",httpMethod = "DELETE",nickname = "eliminarGrado")
	public ResponseEntity<?> eliminar(@ApiParam(value = "Identificador del Grado", required = true)
										@PathVariable(name = "id") Integer id){
		Grado grado = service.buscarPorId(id);
		if(grado == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Buscar la informacion de un grado",httpMethod = "GET",nickname = "buscarGrado")
	public ResponseEntity<?> buscarPorId(@ApiParam(value = "Identificador del Grado", required = true)
											@PathVariable(name = "id") Integer id){
		Grado grado = service.buscarPorId(id);
		if(grado == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(grado,HttpStatus.OK);
	}
}
