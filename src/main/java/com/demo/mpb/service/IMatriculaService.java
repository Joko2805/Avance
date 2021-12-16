package com.demo.mpb.service;

import com.demo.mpb.model.Matricula;
import com.demo.mpb.util.ICrud;

public interface IMatriculaService extends ICrud<Matricula>{

	Matricula buscarPorNombreUsuario(String nombreUsuario);
}
