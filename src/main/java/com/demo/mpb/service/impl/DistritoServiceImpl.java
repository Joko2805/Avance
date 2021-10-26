package com.demo.mpb.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mpb.model.Distrito;
import com.demo.mpb.repository.IDistritoRepository;
import com.demo.mpb.service.IDistritoService;

@Service
@Transactional
public class DistritoServiceImpl implements IDistritoService{

	@Autowired
	private IDistritoRepository repository;

	@Override
	public void registrar(Distrito objeto) {
		repository.save(objeto);
	}

	@Override
	public void actualizar(Distrito objeto) {
		repository.save(objeto);
	}

	@Override
	public void eliminar(Integer id) {
		repository.eliminar(id);
	}

	@Override
	public Distrito buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Distrito> listar() {
		return (List<Distrito>) repository.findAll();
	}

}
