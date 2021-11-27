package com.demo.mpb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Contiene toda la informacion relativa de los trabajadores")
@Entity
@Table(name = "trabajadores")
public class Trabajador implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Identificador del Trabajador")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trabajador_id")
	private Integer trabajadorId;
	
	@Column(length = 8)
	private String dni;
	
	@Column(length = 30)
	private String nombre;
	
	@Column(name = "apellido_paterno", length = 50)
	private String apellidoPaterno;
	
	@Column(name = "apellido_materno", length = 50)
	private String apellidoMaterno;
	
	@Column(length = 70)
	private String direccion;
	
	@Column(length = 11)
	private String telefono;
	
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaIngreso;
	
	@Column
	private Byte estado;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (usuario_id) "
																+ "references usuarios(usuario_id)"))
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (cargo_id) "
																+ "references cargos(cargo_id)"))
	private Cargo cargo;
	
	@ManyToOne
	@JoinColumn(name = "distrito_id", nullable = false,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (distrito_id) "
																+ "references distritos(distrito_id)"))
	private Distrito distrito;
	
	@JsonIgnore
	@OneToMany(mappedBy = "trabajador", cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Asignacion> itemsAsignacion = new ArrayList<>();

	public Trabajador() {
		super();
	}

	public Trabajador(Integer trabajadorId, String dni, String nombre, String apellidoPaterno, String apellidoMaterno,
			String direccion, String telefono, Date fechaNacimiento, Date fechaIngreso, Byte estado) {
		super();
		this.trabajadorId = trabajadorId;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
		this.estado = estado;
	}

	public Integer getTrabajadorId() {
		return trabajadorId;
	}

	public void setTrabajadorId(Integer trabajadorId) {
		this.trabajadorId = trabajadorId;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Byte getEstado() {
		return estado;
	}

	public void setEstado(Byte estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public List<Asignacion> getItemsAsignacion() {
		return itemsAsignacion;
	}

	public void setItemsAsignacion(List<Asignacion> itemsAsignacion) {
		this.itemsAsignacion = itemsAsignacion;
	}
	
}
