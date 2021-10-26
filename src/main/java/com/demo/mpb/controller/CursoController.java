package com.demo.mpb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.mpb.model.Curso;
import com.demo.mpb.service.ICursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private ICursoService service;

	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		return null;
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Curso curso){
		return null;
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody Curso curso){
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
