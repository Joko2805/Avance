package com.demo.mpb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Contiene toda la informacion relativa de los grados")
@Entity
@Table(name = "grados")
public class Grado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Identificador del Grado")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "grado_id")
	private Integer gradoId;

	@Column(length = 70)
	private String nombre;
	
	@Column
	private Byte estado;
	
	@JsonIgnore
	@OneToMany(mappedBy = "grado", cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Seccion> itemsSeccion = new ArrayList<>();
	
	@OneToMany(mappedBy = "grado", cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Curso> itemsCurso = new ArrayList<>();
	
	public Grado() {
		
	}
	
	public Grado(Integer gradoId, String nombre, Byte estado, List<Seccion> itemsSeccion) {
		super();
		this.gradoId = gradoId;
		this.nombre = nombre;
		this.estado = estado;
		this.itemsSeccion = itemsSeccion;
	}

	public Integer getGradoId() {
		return gradoId;
	}

	public void setGradoId(Integer gradoId) {
		this.gradoId = gradoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Byte getEstado() {
		return estado;
	}

	public void setEstado(Byte estado) {
		this.estado = estado;
	}

	public List<Seccion> getItemsSeccion() {
		return itemsSeccion;
	}

	public void setItemsSeccion(List<Seccion> itemsSeccion) {
		this.itemsSeccion = itemsSeccion;
	}
}
