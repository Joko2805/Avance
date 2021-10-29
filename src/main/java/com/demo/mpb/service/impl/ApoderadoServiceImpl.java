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
		repository.save(objeto);
	}

	@Override
	public void actualizar(Apoderado objeto) {
		repository.save(objeto);		
	}

	@Override
	public void eliminar(Integer id) {
		repository.eliminar(id);		
	}

	@Override
	public Apoderado buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Apoderado> listar() {
		return (List<Apoderado>) repository.findAll();
	}
}
