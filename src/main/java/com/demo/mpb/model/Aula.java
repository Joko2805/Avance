package com.demo.mpb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Contiene toda la informacion relativa de las aulas")
@Entity
@Table(name = "aulas")
public class Aula implements Serializable{
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Identificador del Aula")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aula_id")
	private Integer aulaId;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "estado")
	private Byte estado;
	
	@JsonIgnore
	@OneToMany(mappedBy = "aula", cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Seccion> itemsSecciones = new ArrayList<>();

	public Integer getAulaId() {
		return aulaId;
	}

	public void setAulaId(Integer aulaId) {
		this.aulaId = aulaId;
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
