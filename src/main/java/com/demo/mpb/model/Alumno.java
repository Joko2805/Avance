package com.demo.mpb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alumno_id")
	private Integer alumnoId;
	
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
	
	@Column
	private Byte estado;
	
	@ManyToOne
	@JoinColumn(name = "distrito_id", nullable = false,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (distrito_id)"
															+ " references distritos(distrito_id)"))
	private Distrito distrito;
	
	@ManyToOne
	@JoinColumn(name = "apoderado_id", nullable = false,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (apoderado_id)"
															+ " references apoderados(apoderado_id)"))
	private Apoderado apoderado;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (usuario_id)"
															+ " references usuarios(usuario_id)"))
	private Usuario usuario;
	
	@OneToMany(mappedBy = "alumno", cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Matricula> itemsMatriculas = new ArrayList<>();
	
	public Alumno() {
		super();
	}

	public Alumno(Integer alumnoId, String dni, String nombre, String apellidoPaterno, String apellidoMaterno,
			String direccion, String telefono, Date fechaNacimiento, Byte estado) {
		super();
		this.alumnoId = alumnoId;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.estado = estado;
	}

	public Integer getAlumnoId() {
		return alumnoId;
	}

	public void setAlumnoId(Integer alumnoId) {
		this.alumnoId = alumnoId;
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

	public Byte getEstado() {
		return estado;
	}

	public void setEstado(Byte estado) {
		this.estado = estado;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public Apoderado getApoderado() {
		return apoderado;
	}

	public void setApoderado(Apoderado apoderado) {
		this.apoderado = apoderado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
