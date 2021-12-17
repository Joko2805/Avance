package com.demo.mpb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.mpb.model.Curso;

@Repository
public interface ICursoRepository extends CrudRepository<Curso, Integer>{

	@Modifying
	@Query(value = "UPDATE Curso c SET c.estado = 0 WHERE c.cursoId = :id")
	void eliminar(@Param("id") Integer id);

	@Query(value = "SELECT c FROM Curso c WHERE c.grado.gradoId = :id")
	List<Curso> listarCursosPorGrado(@Param("id") Integer gradoId);
}
