package com.demo.mpb.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mpb.model.Horario;
import com.demo.mpb.repository.IHorarioRepository;
import com.demo.mpb.service.IHorarioService;

@Service
@Transactional
public class HorarioServiceImpl implements IHorarioService{

	@Autowired
	private IHorarioRepository repository;
	
	@Override
	public void registrar(Horario objeto) {
		repository.save(objeto);
	}

	@Override
	public void actualizar(Horario objeto) {
		repository.save(objeto);
	}

	@Override
	public void eliminar(Integer id) {
		repository.eliminar(id);
	}

	@Override
	public Horario buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Horario> listar() {
		return (List<Horario>) repository.findAll();
	}

}
