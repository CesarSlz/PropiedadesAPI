package com.terrapp.propiedadesapi.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import org.springframework.data.querydsl.binding.QuerydslPredicate;

@Entity
@NamedQuery(name = "Inmobiliaria.getByVip", 
query = "SELECT i FROM Inmobiliaria i WHERE i.vip = 1 ORDER BY i.nombre ASC")
public class Inmobiliaria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_domicilio", referencedColumnName = "id")
	private Domicilio domicilio;

	private String nombre;
	private String telefono;
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String url;
	@Column(name = "logo_url")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String logoUrl;
	private boolean vip;
	private boolean eliminado;

	@Column(name = "fecha_creacion")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Date fechaCreacion;
	private Date fechaEliminacion;
	private Date fechaModificacion;

	public Inmobiliaria() {
		// TODO Auto-generated constructor stub
	}

	public Inmobiliaria(Integer id, Domicilio domicilio, String nombre, String telefono) {
		this.id = id;
		this.domicilio = domicilio;
		this.nombre = nombre;
		this.telefono = telefono;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
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

	public Boolean getVip() {
		return vip;
	}

	public void setVip(Boolean vip) {
		this.vip = vip;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

}
