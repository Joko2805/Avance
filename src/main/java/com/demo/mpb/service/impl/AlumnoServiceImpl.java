package com.demo.mpb.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mpb.model.Alumno;
import com.demo.mpb.repository.IAlumnoRepository;
import com.demo.mpb.service.IAlumnoService;

@Service
@Transactional
public class AlumnoServiceImpl implements IAlumnoService{
	
	@Autowired
	private IAlumnoRepository repository;

	@Override
	public void registrar(Alumno objeto) {
		repository.save(objeto);
	}

	@Override
	public void actualizar(Alumno objeto) {
		repository.save(objeto);
	}

	@Override
	public void eliminar(Integer id) {
		repository.eliminar(id);
	}

	@Override
	public Alumno buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Alumno> listar() {
		return (List<Alumno>) repository.findAll();
	}

	@Override
	public Alumno buscarPorNombreUsuario(String usuario) {
		return repository.buscarPorNombreUsuario(usuario);
	}	
}
