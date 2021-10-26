package com.demo.mpb.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.mpb.model.Cargo;

public interface ICargoRepository extends CrudRepository<Cargo, Integer>{
	
	@Modifying
	@Query(value = "UPDATE Cargo c SET c.estado = 0 WHERE c.cargoId = :id")
	void eliminar(@Param("id") Integer id);
}
