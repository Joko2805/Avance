package com.demo.mpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.demo.mpb.model.Apoderado;
import com.demo.mpb.service.IApoderadoService;

@RestController
@RequestMapping("/apoderado")
public class ApoderadoController {

	@Autowired
	private IApoderadoService service;

	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		List<Apoderado> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Apoderado apoderado){
		service.registrar(apoderado);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody Apoderado apoderado){
		Apoderado a = service.buscarPorId(apoderado.getApoderadoId());
		if(a == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.actualizar(apoderado);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Integer id){
		Apoderado apoderado = service.buscarPorId(id);
		if(apoderado == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable(name = "id") Integer id){
		Apoderado apoderado = service.buscarPorId(id);
		if(apoderado == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(apoderado,HttpStatus.OK);
	}

}
