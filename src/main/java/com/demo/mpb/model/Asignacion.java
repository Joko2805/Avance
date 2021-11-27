package com.demo.mpb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Contiene toda la informacion relativa de las asignaciones")
@Entity
@Table(name = "asignaciones")
public class Asignacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Identificador de la asignacion")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "asignacion_id")
	private Integer asignacionId;
	
	@Column(length = 70)
	private String descripcion;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@Column
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "trabajador_id", nullable = false,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (trabajador_id) "
																+ "references trabajadores(trabajador_id)"))
	private Trabajador trabajador;
	
	@ManyToOne
	@JoinColumn(name = "curso_id", nullable = false,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (curso_id) "
																+ "references cursos(curso_id)"))
	private Curso curso;
	
	@JsonIgnore
	@OneToMany(mappedBy = "asignacion", cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Horario> itemsHorarios = new ArrayList<>();
	
	public Asignacion() {
		super();
	}

	public Asignacion(Integer asignacionId, String descripcion) {
		super();
		this.asignacionId = asignacionId;
		this.descripcion = descripcion;
	}

	public Integer getAsignacionId() {
		return asignacionId;
	}

	public void setAsignacionId(Integer asignacionId) {
		this.asignacionId = asignacionId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Horario> getItemsHorarios() {
		return itemsHorarios;
	}

	public void setItemsHorarios(List<Horario> itemsHorarios) {
		this.itemsHorarios = itemsHorarios;
	}
	
}

