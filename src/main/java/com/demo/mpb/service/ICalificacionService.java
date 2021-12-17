package com.demo.mpb.service;

import java.util.List;

import com.demo.mpb.model.Calificacion;
import com.demo.mpb.util.ICrud;

public interface ICalificacionService extends ICrud<Calificacion> {
	
	List<Calificacion> calificacionPorMatricula(Integer id);
}
