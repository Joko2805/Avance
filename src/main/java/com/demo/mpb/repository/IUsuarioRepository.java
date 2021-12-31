package com.demo.mpb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.mpb.model.Usuario;

@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Integer>{

	@Modifying
	@Query(value = "UPDATE Usuario u SET u.estado = 0 WHERE u.usuarioId = :id")
	void eliminar(@Param("id") Integer id);
	
	Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}
