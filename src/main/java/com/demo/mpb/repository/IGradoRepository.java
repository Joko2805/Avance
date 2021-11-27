package com.demo.mpb.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.mpb.model.Grado;

@Repository
public interface IGradoRepository extends CrudRepository<Grado, Integer>{

	@Modifying
	@Query(value = "UPDATE Grado g SET g.estado = 0 WHERE g.gradoId = :id")
	void eliminar(@Param("id") Integer id);
}
