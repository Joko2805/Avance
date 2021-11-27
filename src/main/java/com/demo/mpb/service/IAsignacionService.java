package com.demo.mpb.service;

import java.util.List;

import com.demo.mpb.model.Asignacion;

public interface IAsignacionService {
	void registrar(Asignacion asignacion);
	void actualizar(Asignacion asignacion);
	void eliminar(Integer id);
	Asignacion buscarPorId(Integer id);
	List<Asignacion> listar();
}
