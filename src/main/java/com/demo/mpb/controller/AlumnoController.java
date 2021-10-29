package com.demo.mpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.demo.mpb.model.Alumno;
import com.demo.mpb.service.IAlumnoService;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
	
	@Autowired
	private IAlumnoService service;

	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		List<Alumno> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Alumno alumno){
		service.registrar(alumno);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody Alumno alumno){
		Alumno a = service.buscarPorId(alumno.getAlumnoId());
		if(a == null)
			throw new ResponseStatusException(HttpStatus.OK);
		service.actualizar(alumno);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Integer id){
		Alumno alumno = service.buscarPorId(id);
		if(alumno == null)
			throw new ResponseStatusException(HttpStatus.OK);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable(name = "id") Integer id){
		Alumno alumno = service.buscarPorId(id);
		if(alumno == null)
			throw new ResponseStatusException(HttpStatus.OK);
		return new ResponseEntity<>(alumno,HttpStatus.OK);
	}
}
