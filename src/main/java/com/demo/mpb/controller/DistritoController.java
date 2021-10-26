package com.demo.mpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.demo.mpb.model.Distrito;
import com.demo.mpb.service.IDistritoService;

@RestController
@RequestMapping("/distrito")
public class DistritoController {

	@Autowired
	private IDistritoService service;

	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		List<Distrito> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Distrito distrito){
		service.registrar(distrito);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody Distrito distrito){
		Distrito d = service.buscarPorId(distrito.getDistritoId());
		if(d == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.actualizar(distrito);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Integer id){
		Distrito d = service.buscarPorId(id);
		if(d == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable(name = "id") Integer id){
		Distrito d = service.buscarPorId(id);
		if(d == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(d,HttpStatus.OK);
	}
}
