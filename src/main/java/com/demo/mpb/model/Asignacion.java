package com.demo.mpb.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "asignaciones")
public class Asignacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer asignacionId;
	
	@Column(length = 70)
	private String descripcion;
	
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
}
