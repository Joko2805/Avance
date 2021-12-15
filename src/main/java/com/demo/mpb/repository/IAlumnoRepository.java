package com.demo.mpb.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.mpb.model.Alumno;

@Repository
public interface IAlumnoRepository extends CrudRepository<Alumno, Integer>{

	@Modifying
	@Query(value = "UPDATE Alumno a SET a.estado = 0 WHERE a.alumnoId = :id")
	void eliminar(@Param("id") Integer id);
	
	@Query(value = "SELECT a FROM Alumno a WHERE a.usuario.nombreUsuario = :usuario")
	Alumno buscarPorNombreUsuario(@Param("usuario") String usuario);
}
