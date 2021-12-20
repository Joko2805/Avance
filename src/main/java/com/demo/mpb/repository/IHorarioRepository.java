package com.demo.mpb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.mpb.model.Horario;

public interface IHorarioRepository extends CrudRepository<Horario, Integer>{

	@Modifying
	@Query(value = "UPDATE Horario h SET h.estado = 0 WHERE h.horarioId = :id")
	void eliminar(@Param("id") Integer id);
	
	@Query(value = "SELECT h FROM Horario h WHERE h.seccion.seccionId = :id")
	List<Horario> horarioPorSeccion(@Param("id") Integer id);
}
