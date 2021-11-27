package com.demo.mpb.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.mpb.model.Asignacion;

@Repository
public interface IAsignacionRepository extends CrudRepository<Asignacion, Integer> {
	
	@Modifying
	@Query(value = "UPDATE Asignacion a SET a.estado = 0 WHERE a.asignacionId = :id")
	void eliminar(@Param("id") Integer id);
}
