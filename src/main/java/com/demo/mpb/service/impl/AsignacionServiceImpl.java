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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Asignacion asignacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Asignacion buscarId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Asignacion> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
