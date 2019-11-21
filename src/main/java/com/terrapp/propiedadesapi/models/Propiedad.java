package com.terrapp.propiedadesapi.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@NamedQuery(name = "Propiedad.getByEstatus", 
query = "SELECT p FROM Propiedad p WHERE LOWER(p.estatus) = LOWER('Destacada') ORDER BY p.fechaCreacion")
public class Propiedad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_domicilio", referencedColumnName = "id")
	private Domicilio domicilio;

	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario usuario;
	private String descripcion;
	private String mantenimiento;
	private String antiguedad;
	private String estatus;
	private String areaTerreno;
	private String areaConstruccion;
	private boolean eliminado;

	@JsonManagedReference
	@OneToMany(mappedBy = "propiedad")
	private Set<Fotos> fotos;

	@JsonManagedReference
	@OneToOne(mappedBy = "propiedad")
	private AreasCompartidas areasCompartidas;

	@JsonManagedReference
	@OneToOne(mappedBy = "propiedad")
	private Caracteristicas caracteristicas;

	@JsonManagedReference
	@OneToOne(mappedBy = "propiedad")
	private Servicios servicios;

	@JsonManagedReference
	@OneToOne(mappedBy = "propiedad")
	private Casa casa;

	@JsonManagedReference
	@OneToOne(mappedBy = "propiedad")
	private Departamento departamento;

	@JsonManagedReference
	@OneToOne(mappedBy = "propiedad")
	private Terreno terreno;

	@JsonManagedReference
	@OneToOne(mappedBy = "propiedad")
	private Venta venta;

	@JsonManagedReference
	@OneToOne(mappedBy = "propiedad")
	private Renta renta;

	@Column(name = "fecha_creacion")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Date fechaCreacion;
	private Date fechaEliminacion;
	private Date fechaModificacion;

	public Propiedad() {
	}

	public Propiedad(Integer id, Domicilio domicilio, Usuario usuario, String descripcion, String mantenimiento,
			String antiguedad, String estatus, String areaTerreno, String areaConstruccion, boolean eliminado,
			Date fechaCreacion, Date fechaEliminacion) {
		this.domicilio = domicilio;
		this.usuario = usuario;
		this.descripcion = descripcion;
		this.mantenimiento = mantenimiento;
		this.antiguedad = antiguedad;
		this.estatus = estatus;
		this.areaTerreno = areaTerreno;
		this.areaConstruccion = areaConstruccion;
		this.fechaCreacion = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMantenimiento() {
		return mantenimiento;
	}

	public void setMantenimiento(String mantenimiento) {
		this.mantenimiento = mantenimiento;
	}

	public String getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstado(String estatus) {
		this.estatus = estatus;
	}

	public String getAreaTerreno() {
		return areaTerreno;
	}

	public void setAreaTerreno(String areaTerreno) {
		this.areaTerreno = areaTerreno;
	}

	public String getAreaConstruccion() {
		return areaConstruccion;
	}

	public void setAreaConstruccion(String areaConstruccion) {
		this.areaConstruccion = areaConstruccion;
	}

	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaEliminacion() {
		return fechaEliminacion;
	}

	public void setFechaEliminacion(Date fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Set<Fotos> getFotos() {
		return fotos;
	}

	public void setFotos(Set<Fotos> fotos) {
		this.fotos = fotos;
	}

}
