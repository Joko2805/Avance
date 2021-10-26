package com.demo.mpb.service;

import java.util.List;

import com.demo.mpb.model.Matricula;

public interface IMatriculaService {
	void registrar(Matricula matricula);
	void actualizar(Matricula matricula);
	void eliminar(Integer id);
	Matricula buscarId(Integer id);
	List<Matricula> listar();
}
