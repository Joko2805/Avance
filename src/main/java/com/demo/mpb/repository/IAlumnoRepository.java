package com.demo.mpb.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.mpb.model.Alumno;

public interface IAlumnoRepository extends CrudRepository<Alumno, Integer>{

	@Modifying
	@Query(value = "UPDATE Alumno a SET a.estado = 0 WHERE a.alumnoId = :id")
	void eliminar(@Param("id") Integer id);
}
