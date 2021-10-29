package com.demo.mpb.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mpb.model.Seccion;
import com.demo.mpb.repository.ISeccionRepository;
import com.demo.mpb.service.ISeccionService;

@Service
@Transactional
public class SeccionServiceImpl implements ISeccionService{

	@Autowired
	private ISeccionRepository repository;

	@Override
	public void registrar(Seccion objeto) {
		repository.save(objeto);
	}

	@Override
	public void actualizar(Seccion objeto) {
		repository.save(objeto);
	}

	@Override
	public void eliminar(Integer id) {
		repository.eliminar(id);
	}

	@Override
	public Seccion buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Seccion> listar() {
		return (List<Seccion>) repository.findAll();
	}

}
