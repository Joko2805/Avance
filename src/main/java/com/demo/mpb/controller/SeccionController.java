package com.demo.mpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.demo.mpb.model.Seccion;
import com.demo.mpb.service.ISeccionService;

@RestController
@RequestMapping("/seccion")
public class SeccionController {

	@Autowired
	private ISeccionService service;

	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		List<Seccion> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Seccion seccion){
		service.registrar(seccion);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody Seccion seccion){
		Seccion s = service.buscarPorId(seccion.getSeccionId());
		if(s == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.actualizar(seccion);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Integer id){
		Seccion seccion = service.buscarPorId(id);
		if(seccion == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable(name = "id") Integer id){
		Seccion seccion = service.buscarPorId(id);
		if(seccion == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(seccion,HttpStatus.OK);
	}
}
