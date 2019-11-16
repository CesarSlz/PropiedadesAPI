package com.terrapp.propiedadesapi.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Servicios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_propiedad", referencedColumnName = "id")
	private Propiedad propiedad;
	private boolean gas;
	private boolean ac;
	private boolean cisterna;
	private boolean calefaccion;
	private boolean gimnasio;
	private boolean seguridadPrivada;
	private boolean calentadorAgua;
	private boolean eliminado;
	
	@Column(name = "fecha_creacion")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date fechaEliminacion;

	public Servicios() {
	}

	public Servicios(int id, Propiedad propiedad, boolean gas, boolean ac, boolean cisterna, boolean calefaccion,
			boolean gimnasio, boolean seguridadPrivada, boolean calentadorAgua, boolean eliminado, Date fechaCreacion,
			Date fechaEliminacion) {
		this.propiedad = propiedad;
		this.gas = gas;
		this.ac = ac;
		this.cisterna = cisterna;
		this.calefaccion = calefaccion;
		this.gimnasio = gimnasio;
		this.seguridadPrivada = seguridadPrivada;
		this.calentadorAgua = calentadorAgua;
		this.fechaCreacion = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	public boolean isGas() {
		return gas;
	}

	public void setGas(boolean gas) {
		this.gas = gas;
	}

	public boolean isAc() {
		return ac;
	}

	public void setAc(boolean ac) {
		this.ac = ac;
	}

	public boolean isCisterna() {
		return cisterna;
	}

	public void setCisterna(boolean cisterna) {
		this.cisterna = cisterna;
	}

	public boolean isCalefaccion() {
		return calefaccion;
	}

	public void setCalefaccion(boolean calefaccion) {
		this.calefaccion = calefaccion;
	}

	public boolean isGimnasio() {
		return gimnasio;
	}

	public void setGimnasio(boolean gimnasio) {
		this.gimnasio = gimnasio;
	}

	public boolean isSeguridadPrivada() {
		return seguridadPrivada;
	}

	public void setSeguridadPrivada(boolean seguridadPrivada) {
		this.seguridadPrivada = seguridadPrivada;
	}

	public boolean isCalentadorAgua() {
		return calentadorAgua;
	}

	public void setCalentadorAgua(boolean calentadorAgua) {
		this.calentadorAgua = calentadorAgua;
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

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaEliminacion() {
		return fechaEliminacion;
	}

	public void setFechaEliminacion(Date fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}

}
