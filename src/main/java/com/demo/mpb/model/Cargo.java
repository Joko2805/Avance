package com.demo.mpb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "cargos")
public class Cargo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cargo_id")
	private Integer cargoId;
	
	@Column(length = 50)
	private String descripcion;
	
	@Column
	private Byte estado;
	
	@OneToMany(mappedBy = "cargo")
	private List<Trabajador> itemsTrabajador = new ArrayList<>();

	public Cargo() {
		super();
	}

	public Cargo(Integer cargoId, String descripcion, Byte estado) {
		super();
		this.cargoId = cargoId;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public Integer getCargoId() {
		return cargoId;
	}

	public void setCargoId(Integer cargoId) {
		this.cargoId = cargoId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Byte getEstado() {
		return estado;
	}

	public void setEstado(Byte estado) {
		this.estado = estado;
	}
}
