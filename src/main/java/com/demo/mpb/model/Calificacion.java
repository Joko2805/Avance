package com.demo.mpb.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "calificaciones")
public class Calificacion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "calificacion_id")
	private Integer calificacionId;
	
	@Column
	private Double primerBimestre;
	
	@Column
	private Double segundorBimestre;
	
	@Column
	private Double tercerBimestre;
	
	@Column
	private Double cuartoBimestre;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column
	private Byte estado;
	
	@ManyToOne
	@JoinColumn(name = "matricula_id", nullable = false,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (matricula_id)"
															+ " references matriculas(matricula_id)"))
	private Matricula matricula;
	
	@ManyToOne
	@JoinColumn(name = "curso_id", nullable = false,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (curso_id)"
															+ " references cursos(curso_id)"))
	private Curso curso;
	
	public Calificacion() {
		super();
	}

	public Calificacion(Integer calificacionId, Double primerBimestre, Double segundorBimestre, Double tercerBimestre,
			Double cuartoBimestre, Date fecha, Byte estado) {
		super();
		this.calificacionId = calificacionId;
		this.primerBimestre = primerBimestre;
		this.segundorBimestre = segundorBimestre;
		this.tercerBimestre = tercerBimestre;
		this.cuartoBimestre = cuartoBimestre;
		this.fecha = fecha;
		this.estado = estado;
	}

	public Integer getCalificacionId() {
		return calificacionId;
	}

	public void setCalificacionId(Integer calificacionId) {
		this.calificacionId = calificacionId;
	}

	public Double getPrimerBimestre() {
		return primerBimestre;
	}

	public void setPrimerBimestre(Double primerBimestre) {
		this.primerBimestre = primerBimestre;
	}

	public Double getSegundorBimestre() {
		return segundorBimestre;
	}

	public void setSegundorBimestre(Double segundorBimestre) {
		this.segundorBimestre = segundorBimestre;
	}

	public Double getTercerBimestre() {
		return tercerBimestre;
	}

	public void setTercerBimestre(Double tercerBimestre) {
		this.tercerBimestre = tercerBimestre;
	}

	public Double getCuartoBimestre() {
		return cuartoBimestre;
	}

	public void setCuartoBimestre(Double cuartoBimestre) {
		this.cuartoBimestre = cuartoBimestre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Byte getEstado() {
		return estado;
	}

	public void setEstado(Byte estado) {
		this.estado = estado;
	}
}
