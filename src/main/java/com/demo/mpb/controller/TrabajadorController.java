package com.demo.mpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.demo.mpb.model.Trabajador;
import com.demo.mpb.service.ITrabajadorService;

@RestController
@RequestMapping("/trabajador")
public class TrabajadorController {

	@Autowired
	private ITrabajadorService service;

	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		List<Trabajador> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Trabajador trabajador){
		service.registrar(trabajador);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody Trabajador trabajador){
		Trabajador t = service.buscarPorId(trabajador.getTrabajadorId());
		if(t == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.actualizar(trabajador);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Integer id){
		Trabajador trabajador = service.buscarPorId(id);
		if(trabajador == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable(name = "id") Integer id){
		Trabajador trabajador = service.buscarPorId(id);
		if(trabajador == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(trabajador,HttpStatus.OK);
	}
}
