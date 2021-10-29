package com.demo.mpb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "secciones")
public class Seccion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "seccion_id")
	private Integer seccionId;
	
	@Column(length = 70)
	private String nombre;	
	
	@Column
	private Byte estado;
	
	@ManyToOne
	@JoinColumn(name = "grado_id", nullable = false,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (grado_id)"
																+ " references grados(grado_id)"))
	private Grado grado;
	
	@OneToMany(mappedBy = "seccion", cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Matricula> itemsMatriculas = new ArrayList<>();
	
	public Seccion() {
		
	}

	public Seccion(Integer seccionId, String nombre, Byte estado) {
		super();
		this.seccionId = seccionId;
		this.nombre = nombre;
		this.estado = estado;
	}

	public Integer getSeccionId() {
		return seccionId;
	}

	public void setSeccionId(Integer seccionId) {
		this.seccionId = seccionId;
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

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}
}