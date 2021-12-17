package com.demo.mpb.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mpb.model.Curso;
import com.demo.mpb.repository.ICursoRepository;
import com.demo.mpb.service.ICursoService;

@Service
@Transactional
public class CursoServiceImpl implements ICursoService{
	
	@Autowired
	private ICursoRepository repository;

	@Override
	public void registrar(Curso objeto) {
		repository.save(objeto);
	}

	@Override
	public void actualizar(Curso objeto) {
		repository.save(objeto);
	}

	@Override
	public void eliminar(Integer id) {
		repository.eliminar(id);
	}

	@Override
	public Curso buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Curso> listar() {
		return (List<Curso>) repository.findAll();
	}

	@Override
	public List<Curso> listarCursoPorGrado(Integer gradoId) {
		return repository.listarCursosPorGrado(gradoId);
	}

}
