package com.demo.mpb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.mpb.model.Seccion;
import com.demo.mpb.service.ISeccionService;

@RestController
@RequestMapping("/seccion")
public class SeccionController {

	@Autowired
	private ISeccionService service;

	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		return null;
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Seccion seccion){
		return null;
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody Seccion seccion){
		return null;
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Integer id){
		return null;
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable(name = "id") Integer id){
		return null;
	}
}
