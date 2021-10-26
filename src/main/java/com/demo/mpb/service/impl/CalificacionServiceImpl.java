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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Calificacion calificacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Calificacion buscarId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Calificacion> listar() {
		// TODO Auto-generated method stub
		return null;
	}


}
