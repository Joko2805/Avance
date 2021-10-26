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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Seccion objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seccion buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seccion> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
