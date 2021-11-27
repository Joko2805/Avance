package com.demo.mpb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Contiene toda la informacion relativa de los usuarios")
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Identificador del Usuario")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private Integer usuarioId;
	
	@Column(length = 30)
	private String usuario;
	
	@Column(length = 30)
	private String contrasenia;
	
	@Column
	private Byte estado;
	
	@ManyToOne
	@JoinColumn(name = "rol_id", nullable = false,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (rol_id) "
																+ "references roles(rol_id)"))
	private Rol rol;
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Alumno> itemsAlumno = new ArrayList<>();	
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Trabajador> itemsTrabajador = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Apoderado> itemsApoderados = new ArrayList<>();

	public Usuario() {
		super();
	}

	public Usuario(Integer usuarioId, String usuario, String contrasenia, Byte estado, Rol rol) {
		super();
		this.usuarioId = usuarioId;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.estado = estado;
		this.rol = rol;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Byte getEstado() {
		return estado;
	}

	public void setEstado(Byte estado) {
		this.estado = estado;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
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
