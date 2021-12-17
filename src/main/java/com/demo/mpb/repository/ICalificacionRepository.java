package com.demo.mpb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.mpb.model.Calificacion;

@Repository
public interface ICalificacionRepository extends CrudRepository<Calificacion, Integer> {

	@Modifying
	@Query(value = "UPDATE Calificacion c SET c.estado = 0 WHERE c.calificacionId = :id")
	void eliminar(@Param("id") Integer id);
	
	@Query(value = "SELECT c FROM Calificacion c WHERE c.matricula.matriculaId = :id")
	List<Calificacion> calificacionPorMatricula(@Param("id") Integer id);
}
