package com.demo.mpb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cursos")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "curso_id")
	private Integer cursoId;
	
	@Column(length = 50)
	private String nombre;
	
	@Column(length = 50)
	private String descripcion;

	@Column
	private Byte estado;
	
	@ManyToOne
	@JoinColumn(name = "grado_id", nullable = false,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (grado_id) "
																+ "references grados(grado_id)"))
	private Grado grado;
	
	@JsonIgnore
	@OneToMany(mappedBy = "curso", cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Calificacion> itemsCalificacion = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "curso", cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Asignacion> itemsAsignacion = new ArrayList<>();

	public Curso() {
		super();
	}

	public Curso(Integer cursoId, String nombre, String descripcion, Byte estado) {
		super();
		this.cursoId = cursoId;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public Integer getCursoId() {
		return cursoId;
	}

	public void setCursoId(Integer cursoId) {
		this.cursoId = cursoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public List<Calificacion> getItemsCalificacion() {
		return itemsCalificacion;
	}

	public void setItemsCalificacion(List<Calificacion> itemsCalificacion) {
		this.itemsCalificacion = itemsCalificacion;
	}

	public List<Asignacion> getItemsAsignacion() {
		return itemsAsignacion;
	}

	public void setItemsAsignacion(List<Asignacion> itemsAsignacion) {
		this.itemsAsignacion = itemsAsignacion;
	}
}
