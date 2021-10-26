package com.demo.mpb.util;

import java.util.List;

public interface ICrud<T> {
	void registrar(T objeto);
	void actualizar(T objeto);
	void eliminar(Integer id);
	T buscarPorId(Integer id);
	List<T> listar();
}
