package com.demo.mpb.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mpb.model.Asignacion;
import com.demo.mpb.repository.IAsignacionRepository;
import com.demo.mpb.service.IAsignacionService;

@Service
@Transactional
public class AsignacionServiceImpl implements IAsignacionService{
	
	@Autowired
	private IAsignacionRepository repository;

	@Override
	public void registrar(Asignacion asignacion) {
		repository.save(asignacion);
	}

	@Override
	public void actualizar(Asignacion asignacion) {
		repository.save(asignacion);
	}

	@Override
	public void eliminar(Integer id) {
		repository.eliminar(id);
	}

	@Override
	public Asignacion buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Asignacion> listar() {
		return (List<Asignacion>) repository.findAll();
	}

}
