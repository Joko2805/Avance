package com.demo.mpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.demo.mpb.model.Rol;
import com.demo.mpb.service.IRolService;

@RestController
@RequestMapping("/rol")
public class RolController {

	@Autowired
	private IRolService service;

	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		List<Rol> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Rol rol){
		service.registrar(rol);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody Rol rol){
		Rol r = service.buscarPorId(rol.getRolId());
		if(r == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.actualizar(rol);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Integer id){
		Rol rol = service.buscarPorId(id);
		if(rol == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable(name = "id") Integer id){
		Rol rol = service.buscarPorId(id);
		if(rol == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(rol,HttpStatus.OK);
	}
}
