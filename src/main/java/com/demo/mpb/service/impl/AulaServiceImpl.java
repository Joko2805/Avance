package com.demo.mpb.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mpb.model.Aula;
import com.demo.mpb.repository.IAulaRepository;
import com.demo.mpb.service.IAulaService;

@Service
@Transactional
public class AulaServiceImpl implements IAulaService{

	@Autowired
	private IAulaRepository repository;
	
	@Override
	public void registrar(Aula objeto) {
		repository.save(objeto);
	}

	@Override
	public void actualizar(Aula objeto) {
		repository.save(objeto);
	}

	@Override
	public void eliminar(Integer id) {
		repository.eliminar(id);
	}

	@Override
	public Aula buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Aula> listar() {
		return (List<Aula>) repository.findAll();
	}

}
