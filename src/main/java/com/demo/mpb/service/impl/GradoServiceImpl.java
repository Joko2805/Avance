package com.demo.mpb.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mpb.model.Grado;
import com.demo.mpb.repository.IGradoRepository;
import com.demo.mpb.service.IGradoService;

@Service
@Transactional
public class GradoServiceImpl implements IGradoService{

	@Autowired
	private IGradoRepository repository;

	@Override
	public void registrar(Grado objeto) {
		repository.save(objeto);
	}

	@Override
	public void actualizar(Grado objeto) {
		repository.save(objeto);
	}

	@Override
	public void eliminar(Integer id) {
		repository.eliminar(id);
	}

	@Override
	public Grado buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Grado> listar() {
		return (List<Grado>) repository.findAll();
	}

}
