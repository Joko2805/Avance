package com.demo.mpb.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.mpb.model.Rol;

public interface IRolRepository extends CrudRepository<Rol, Integer>{

	@Modifying
	@Query(value = "UPDATE Rol r SET r.estado = 0 WHERE r.rolId = :id")
	void eliminar(@Param("id") Integer id);
}
