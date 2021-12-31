package com.demo.mpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.demo.mpb.model.Usuario;
import com.demo.mpb.service.IUsuarioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private IUsuarioService service;

	@GetMapping(value = "/listar", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ApiOperation(value = "Devuelve la lista de los usuarios", httpMethod = "GET", nickname = "listarUsuario")
	public ResponseEntity<?> listar() {
		List<Usuario> lista = service.listar();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@PostMapping(value = "/registrar", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	@ApiOperation(value = "Registra un nuevo usuario", httpMethod = "POST", nickname = "registrarUsuario")
	public ResponseEntity<?> registrar(@RequestBody Usuario usuario) {
		service.registrar(usuario);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping(value = "/actualizar", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	@ApiOperation(value = "Actualizar la informacion de un usuario", httpMethod = "PUT", nickname = "actualizarUsuario")
	public ResponseEntity<?> actualizar(@RequestBody Usuario usuario) {
		Usuario u = service.buscarPorId(usuario.getUsuarioId());
		if (u == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.actualizar(usuario);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/eliminar/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ApiOperation(value = "Elimina un usuario", httpMethod = "DELETE", nickname = "eliminarUsuario")
	public ResponseEntity<?> eliminar(
			@ApiParam(value = "Identificador del Usuario", required = true) @PathVariable(name = "id") Integer id) {
		Usuario usuario = service.buscarPorId(id);
		if (usuario == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/buscar/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ApiOperation(value = "Buscar la informacion de un usuario", httpMethod = "GET", nickname = "buscarUsuario")
	public ResponseEntity<?> buscarPorId(
			@ApiParam(value = "Identificador del Usuario", required = true) @PathVariable(name = "id") Integer id) {
		Usuario usuario = service.buscarPorId(id);
		if (usuario == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
}
