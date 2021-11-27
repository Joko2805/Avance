package com.demo.mpb.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.mpb.model.Matricula;

@Repository
public interface IMatriculaRepository extends CrudRepository<Matricula, Integer>{

	@Modifying
	@Query(value = "UPDATE Matricula m SET m.estado = 0 WHERE m.matriculaId = :id")
	void eliminar(@Param("id") Integer id);
}
