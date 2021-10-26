package com.demo.mpb.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.mpb.model.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Integer>{

	@Modifying
	@Query(value = "UPDATE Usuario u SET u.estado = 0 WHERE u.usuarioId = :id")
	void eliminar(@Param("id") Integer id);
}
