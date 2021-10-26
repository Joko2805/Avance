package com.demo.mpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.demo.mpb.model.Grado;
import com.demo.mpb.service.IGradoService;

@RestController
@RequestMapping("/grado")
public class GradoController {

	@Autowired
	private IGradoService service;

	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		List<Grado> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Grado grado){
		service.registrar(grado);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody Grado grado){
		Grado g = service.buscarPorId(grado.getGradoId());
		if(g == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.actualizar(grado);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Integer id){
		Grado grado = service.buscarPorId(id);
		if(grado == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable(name = "id") Integer id){
		Grado grado = service.buscarPorId(id);
		if(grado == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(grado,HttpStatus.OK);
	}
}
