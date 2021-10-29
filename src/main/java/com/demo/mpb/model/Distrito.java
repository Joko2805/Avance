package com.demo.mpb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "distritos")
public class Distrito implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "distrito_id")
	private Integer distritoId;

	@Column(length = 70)
	private String nombre;

	@Column
	private Byte estado;
	
	@JsonIgnore
	@OneToMany(mappedBy = "distrito",cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Apoderado> itemsApoderado = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "distrito",cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Alumno> itemsAlumno = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "distrito",cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Trabajador> itemsTrabajador = new ArrayList<>();
	
	public Distrito() {
		
	}
	
	public Distrito(Integer distritoId, String nombre, Byte estado) {
		super();
		this.distritoId = distritoId;
		this.nombre = nombre;
		this.estado = estado;
	}

	public Integer getDistritoId() {
		return distritoId;
	}

	public void setDistritoId(Integer distritoId) {
		this.distritoId = distritoId;
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

	public List<Apoderado> getItemsApoderado() {
		return itemsApoderado;
	}

	public void setItemsApoderado(List<Apoderado> itemsApoderado) {
		this.itemsApoderado = itemsApoderado;
	}

	public List<Alumno> getItemsAlumno() {
		return itemsAlumno;
	}

	public void setItemsAlumno(List<Alumno> itemsAlumno) {
		this.itemsAlumno = itemsAlumno;
	}

	public List<Trabajador> getItemsTrabajador() {
		return itemsTrabajador;
	}

	public void setItemsTrabajador(List<Trabajador> itemsTrabajador) {
		this.itemsTrabajador = itemsTrabajador;
	}
	
}
