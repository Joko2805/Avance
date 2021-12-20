package com.demo.mpb.service;

import java.util.List;

import com.demo.mpb.model.Horario;
import com.demo.mpb.util.ICrud;

public interface IHorarioService extends ICrud<Horario>{
	
	List<Horario> horarioPorSeccion(Integer id);
}
