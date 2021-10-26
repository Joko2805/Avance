package com.demo.mpb.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mpb.model.Apoderado;
import com.demo.mpb.repository.IApoderadoRepository;
import com.demo.mpb.service.IApoderadoService;

@Service
@Transactional
public class ApoderadoServiceImpl implements IApoderadoService{
	
	@Autowired
	private IApoderadoRepository repository;

	@Override
	public void registrar(Apoderado objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Apoderado objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Apoderado buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Apoderado> listar() {
		// TODO Auto-generated method stub
		return null;
	}
}
