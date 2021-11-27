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

import com.demo.mpb.model.Horario;
import com.demo.mpb.service.IHorarioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/horario")
public class HorarioController {

	@Autowired
	private IHorarioService service;
	
	@GetMapping(value = "/listar", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Devuelve la lista de los horarios",httpMethod = "GET",nickname = "listarHorarios")
	public ResponseEntity<?> listar(){
		List<Horario> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping(value = "/registrar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
										produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Registra una nuevo horario",httpMethod = "POST",nickname = "registrarHorario")
	public ResponseEntity<?> registrar(@RequestBody Horario horario){
		service.registrar(horario);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/actualizar", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
										produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Actualizar la informacion de un horario",httpMethod = "PUT",nickname = "actualizarHorario")
	public ResponseEntity<?> actualizar(@RequestBody Horario horario){
		Horario h = service.buscarPorId(horario.getHorarioId());
		if(h == null)
			throw new ResponseStatusException(HttpStatus.OK);
		service.actualizar(horario);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/eliminar/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Elimina un horario",httpMethod = "DELETE",nickname = "eliminarAula")
	public ResponseEntity<?> eliminar(@ApiParam(value = "Identificador de un horario", required = true)
										@PathVariable(name = "id") Integer id){
		Horario horario= service.buscarPorId(id);
		if(horario == null)
			throw new ResponseStatusException(HttpStatus.OK);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscar/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Buscar la informacion de un horario",httpMethod = "GET",nickname = "buscarHorario")
	public ResponseEntity<?> buscarPorId(@ApiParam(value = "Identificador del horario", required = true)
											@PathVariable(name = "id") Integer id){
		Horario horario= service.buscarPorId(id);
		if(horario == null)
			throw new ResponseStatusException(HttpStatus.OK);
		return new ResponseEntity<>(horario,HttpStatus.OK);
	}
}
