package com.demo.mpb.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mpb.model.Usuario;
import com.demo.mpb.repository.IUsuarioRepository;
import com.demo.mpb.service.IUsuarioService;

@Service
@Transactional
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioRepository repository;

	@Override
	public void registrar(Usuario objeto) {
		repository.save(objeto);
	}

	@Override
	public void actualizar(Usuario objeto) {
		repository.save(objeto);	}

	@Override
	public void eliminar(Integer id) {
		repository.eliminar(id);
	}

	@Override
	public Usuario buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Usuario> listar() {
		return (List<Usuario>) repository.findAll();
	}

}
