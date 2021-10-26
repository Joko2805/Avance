package com.demo.mpb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.mpb.model.Apoderado;
import com.demo.mpb.service.IApoderadoService;

@RestController
@RequestMapping("/apoderado")
public class ApoderadoController {

	@Autowired
	private IApoderadoService service;

	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		return null;
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Apoderado apoderado){
		return null;
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody Apoderado apoderado){
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
