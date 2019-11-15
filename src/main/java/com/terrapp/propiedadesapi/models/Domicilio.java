package com.terrapp.propiedadesapi.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Domicilio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String calle;

	private String numeroInt;
	private String numeroExt;
	private String cp;
	private String municipio;
	private String estado;
	private boolean eliminado;

	@Column(name = "fecha_creacion")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Date fechaCreacion;

	private Date fechaModificacion;

	private Date fechaEliminacion;

	public Domicilio() {
	}

	public Domicilio(int id, String calle, String numeroInt, String numeroExt, String cp, String municipio,
			String estado) {
		this.id = id;
		this.calle = calle;
		this.numeroInt = numeroInt;
		this.numeroExt = numeroExt;
		this.cp = cp;
		this.municipio = municipio;
		this.estado = estado;
		this.fechaCreacion = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumeroInt() {
		return numeroInt;
	}

	public void setNumeroInt(String numeroInt) {
		this.numeroInt = numeroInt;
	}

	public String getNumeroExt() {
		return numeroExt;
	}

	public void setNumeroExt(String numeroExt) {
		this.numeroExt = numeroExt;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

}
