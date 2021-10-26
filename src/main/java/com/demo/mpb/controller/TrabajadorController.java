package com.demo.mpb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.mpb.model.Trabajador;
import com.demo.mpb.service.ITrabajadorService;

@RestController
@RequestMapping("/trabajador")
public class TrabajadorController {

	@Autowired
	private ITrabajadorService service;

	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		return null;
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Trabajador trabajador){
		return null;
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody Trabajador trabajador){
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
