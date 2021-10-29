package com.demo.mpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.demo.mpb.model.Curso;
import com.demo.mpb.service.ICursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private ICursoService service;

	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		List<Curso> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Curso curso){
		service.registrar(curso);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody Curso curso){
		Curso c = service.buscarPorId(curso.getCursoId());
		if(c == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.actualizar(curso);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Integer id){
		Curso curso = service.buscarPorId(id);
		if(curso == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable(name = "id") Integer id){
		Curso curso = service.buscarPorId(id);
		if(curso == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(curso,HttpStatus.OK);
	}
}
