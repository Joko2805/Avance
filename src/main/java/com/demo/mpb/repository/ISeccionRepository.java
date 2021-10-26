package com.demo.mpb.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.mpb.model.Seccion;

public interface ISeccionRepository extends CrudRepository<Seccion, Integer>{

	@Modifying
	@Query(value = "UPDATE Seccion s SET s.estado = 0 WHERE s.seccionId = :id")
	void eliminar(@Param("id") Integer id);
}
