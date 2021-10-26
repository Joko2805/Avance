package com.demo.mpb.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mpb.model.Curso;
import com.demo.mpb.repository.IApoderadoRepository;
import com.demo.mpb.service.ICursoService;

@Service
@Transactional
public class CursoServiceImpl implements ICursoService{
	
	@Autowired
	private IApoderadoRepository repository;

	@Override
	public void registrar(Curso objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Curso objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Curso buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Curso> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
