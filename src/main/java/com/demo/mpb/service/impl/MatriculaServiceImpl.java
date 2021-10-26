package com.demo.mpb.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mpb.model.Matricula;
import com.demo.mpb.repository.IMatriculaRepository;
import com.demo.mpb.service.IMatriculaService;

@Service
@Transactional
public class MatriculaServiceImpl implements IMatriculaService{

	@Autowired
	private IMatriculaRepository repository;

	@Override
	public void registrar(Matricula matricula) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Matricula buscarId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Matricula> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
