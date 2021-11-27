package com.demo.mpb.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.mpb.model.Apoderado;

@Repository
public interface IApoderadoRepository extends CrudRepository<Apoderado, Integer>{

	@Modifying
	@Query(value = "UPDATE Apoderado a SET a.estado = 0 WHERE a.apoderadoId = :id")
	void eliminar(@Param("id") Integer id);
}
