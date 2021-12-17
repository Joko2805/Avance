package com.demo.mpb.service;

import java.util.List;

import com.demo.mpb.model.Curso;

import com.demo.mpb.util.ICrud;

public interface ICursoService extends ICrud<Curso>{
	
	List<Curso> listarCursoPorGrado(Integer gradoId);
	
}
