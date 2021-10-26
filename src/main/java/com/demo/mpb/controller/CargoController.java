package com.demo.mpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.demo.mpb.model.Cargo;
import com.demo.mpb.service.ICargoService;

@RestController
@RequestMapping("/cargo")
public class CargoController {

	@Autowired
	private ICargoService service;

	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		List<Cargo> lista = service.listar();		
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Cargo cargo){
		service.registrar(cargo);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody Cargo cargo){
		Cargo c = service.buscarPorId(cargo.getCargoId());
		if(c == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.actualizar(cargo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Integer id){
		Cargo c = service.buscarPorId(id);
		if(c == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable(name = "id") Integer id){
		Cargo cargo = service.buscarPorId(id);
		if(cargo == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(cargo,HttpStatus.OK);
	}
}
