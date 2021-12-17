package com.demo.mpb.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mpb.model.Calificacion;
import com.demo.mpb.repository.ICalificacionRepository;
import com.demo.mpb.service.ICalificacionService;

@Service
@Transactional
public class CalificacionServiceImpl implements ICalificacionService{
	
	@Autowired
	private ICalificacionRepository repository;

	@Override
	public void registrar(Calificacion calificacion) {
		repository.save(calificacion);
	}

	@Override
	public void actualizar(Calificacion calificacion) {
		repository.save(calificacion);
	}

	@Override
	public void eliminar(Integer id) {
		repository.eliminar(id);
	}

	@Override
	public Calificacion buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Calificacion> listar() {
		return (List<Calificacion>) repository.findAll();
	}

	@Override
	public List<Calificacion> calificacionPorMatricula(Integer id) {
		return repository.calificacionPorMatricula(id);
	}
}
