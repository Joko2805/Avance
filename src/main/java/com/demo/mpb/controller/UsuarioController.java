package com.demo.mpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.demo.mpb.model.Usuario;
import com.demo.mpb.service.IUsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private IUsuarioService service;

	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		List<Usuario> lista = service.listar();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Usuario usuario){
		service.registrar(usuario);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody Usuario usuario){
		Usuario u = service.buscarPorId(usuario.getUsuarioId());
		if(u == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.actualizar(usuario);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Integer id){
		Usuario usuario = service.buscarPorId(id);
		if(usuario == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable(name = "id") Integer id){
		Usuario usuario = service.buscarPorId(id);
		if(usuario == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(usuario,HttpStatus.OK);
	}
	
}
