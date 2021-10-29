package com.demo.mpb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "roles")
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rol_id")
	private Integer rolId;

	@Column(length = 70)
	private String descripcion;

	@Column
	private Byte estado;
	
	@JsonIgnore
	@OneToMany(mappedBy = "rol", cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Usuario> itemsUsuario = new ArrayList<>();

	public Rol() {
		
	}
	
	public Rol(Integer rolId, String descripcion, Byte estado) {
		super();
		this.rolId = rolId;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public Integer getRolId() {
		return rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
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

	public List<Usuario> getItemsUsuario() {
		return itemsUsuario;
	}

	public void setItemsUsuario(List<Usuario> itemsUsuario) {
		this.itemsUsuario = itemsUsuario;
	}
	
}
