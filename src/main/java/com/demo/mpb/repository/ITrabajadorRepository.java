package com.demo.mpb.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.mpb.model.Trabajador;

public interface ITrabajadorRepository extends CrudRepository<Trabajador, Integer> {

	@Modifying
	@Query(value = "UPDATE Trabajador t SET t.estado = 0 WHERE t.trabajadorId = :id")
	void eliminar(@Param("id") Integer id);
}
