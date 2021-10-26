package com.demo.mpb.service;

import java.util.List;

import com.demo.mpb.model.Calificacion;

public interface ICalificacionService {
	void registrar(Calificacion calificacion);
	void actualizar(Calificacion calificacion);
	void eliminar(Integer id);
	Calificacion buscarId(Integer id);
	List<Calificacion> listar();
}
