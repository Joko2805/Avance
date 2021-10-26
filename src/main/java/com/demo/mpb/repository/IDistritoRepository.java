package com.demo.mpb.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.mpb.model.Distrito;

public interface IDistritoRepository extends CrudRepository<Distrito, Integer>{

	@Modifying
	@Query(value = "UPDATE Distrito d SET d.estado = 0 WHERE d.distritoId = :id")
	void eliminar(@Param("id") Integer id);
}
