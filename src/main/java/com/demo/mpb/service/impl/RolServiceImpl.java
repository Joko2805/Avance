package com.demo.mpb.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mpb.model.Rol;
import com.demo.mpb.repository.IRolRepository;
import com.demo.mpb.service.IRolService;

@Service
@Transactional
public class RolServiceImpl implements IRolService{

	@Autowired
	private IRolRepository repository;

	@Override
	public void registrar(Rol objeto) {
		repository.save(objeto);
	}

	@Override
	public void actualizar(Rol objeto) {
		repository.save(objeto);
	}

	@Override
	public void eliminar(Integer id) {
		repository.eliminar(id);
	}

	@Override
	public Rol buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Rol> listar() {
		return (List<Rol>) repository.findAll();
	}

}
