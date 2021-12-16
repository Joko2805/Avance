package com.demo.mpb.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mpb.model.Matricula;
import com.demo.mpb.repository.IMatriculaRepository;
import com.demo.mpb.service.IMatriculaService;

@Service
@Transactional
public class MatriculaServiceImpl implements IMatriculaService{

	@Autowired
	private IMatriculaRepository repository;

	@Override
	public void registrar(Matricula matricula) {
		repository.save(matricula);
	}

	@Override
	public void actualizar(Matricula matricula) {
		repository.save(matricula);
	}

	@Override
	public void eliminar(Integer id) {
		repository.eliminar(id);
	}

	@Override
	public Matricula buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Matricula> listar() {
		return (List<Matricula>) repository.findAll();
	}

	@Override
	public Matricula buscarPorNombreUsuario(String nombreUsuario) {
		return repository.buscarPorNombreUsuario(nombreUsuario);
	}

}
