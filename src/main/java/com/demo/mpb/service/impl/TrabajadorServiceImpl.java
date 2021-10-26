package com.demo.mpb.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mpb.model.Trabajador;
import com.demo.mpb.repository.ITrabajadorRepository;
import com.demo.mpb.service.ITrabajadorService;

@Service
@Transactional
public class TrabajadorServiceImpl implements ITrabajadorService{

	@Autowired
	private ITrabajadorRepository repository;

	@Override
	public void registrar(Trabajador objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Trabajador objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Trabajador buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trabajador> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
