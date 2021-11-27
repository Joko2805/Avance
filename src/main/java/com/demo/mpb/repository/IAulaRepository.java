package com.demo.mpb.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.mpb.model.Aula;

public interface IAulaRepository extends CrudRepository<Aula, Integer>{

	@Modifying
	@Query(value = "UPDATE Aula a SET a.estado = 0 WHERE a.aulaId = :id")
	void eliminar(@Param("id") Integer id);
}
