package com.demo.mpb.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.demo.mpb.model.Cargo;
import com.demo.mpb.repository.ICargoRepository;
import com.demo.mpb.service.ICargoService;

@Service
@Transactional
public class CargoServiceImpl implements ICargoService{

	@Autowired
	private ICargoRepository repository;

	@Override
	public void registrar(Cargo objeto) {
		repository.save(objeto);
	}

	@Override
	public void actualizar(Cargo objeto) {
		repository.save(objeto);
	}

	@Override
	public void eliminar(Integer id) {
		repository.eliminar(id);
	}

	@Override
	public Cargo buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Cargo> listar() {
		return (List<Cargo>) repository.findAll();
	}

}
