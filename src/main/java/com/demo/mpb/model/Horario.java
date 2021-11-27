package com.demo.mpb.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Contiene toda la informacion relativa de los horarios")
@Entity
@Table(name = "horarios")
public class Horario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Identificador del horario")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "horario_id")
	private Integer horarioId;
	
	@Temporal(TemporalType.TIME)
	private Date hora;
	
	@Column(name = "dia")
	private String dia;
	
	@Column(name = "estado")
	private Byte estado;
	
	@ManyToOne
	@JoinColumn(name = "asignacion_id", nullable = false,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (asignacion_id) "
																+ "references asignaciones(asignacion_id)"))
	private Asignacion asignacion;
	
	@ManyToOne
	@JoinColumn(name = "seccion_id", nullable = false,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (seccion_id) "
																+ "references secciones(seccion_id)"))
	private Seccion seccion;
	
	@ManyToOne
	@JoinColumn(name = "aula_id", nullable = false,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (aula_id) "
																+ "references aulas(aula_id)"))
	private Aula aula;
	

	public Integer getHorarioId() {
		return horarioId;
	}

	public void setHorarioId(Integer horarioId) {
		this.horarioId = horarioId;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public Asignacion getAsignacion() {
		return asignacion;
	}

	public void setAsignacion(Asignacion asignacion) {
		this.asignacion = asignacion;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}
	
}
