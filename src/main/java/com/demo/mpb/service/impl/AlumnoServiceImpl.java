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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Alumno objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Alumno buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alumno> listar() {
		// TODO Auto-generated method stub
		return null;
	}	
}
