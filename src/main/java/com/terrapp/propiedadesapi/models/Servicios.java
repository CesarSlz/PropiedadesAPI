package com.terrapp.propiedadesapi.models;

import java.util.Date;

public class Servicios {
	private int id;
	private int idPropiedad;
	private boolean gas;
	private boolean ac;
	private boolean cisterna;
	private boolean calefaccion;
	private boolean gimnasio;
	private boolean seguridadPrivada;
	private boolean calentadorAgua;
	private boolean eliminado;
	private Date fechaCreacion;
	private Date fechaEliminacion;

	public Servicios() {
	}

	public Servicios(int id, int idPropiedad, boolean gas, boolean ac, boolean cisterna, boolean calefaccion,
			boolean gimnasio, boolean seguridadPrivada, boolean calentadorAgua, boolean eliminado, Date fechaCreacion,
			Date fechaEliminacion) {
		this.id = id;
		this.idPropiedad = idPropiedad;
		this.gas = gas;
		this.ac = ac;
		this.cisterna = cisterna;
		this.calefaccion = calefaccion;
		this.gimnasio = gimnasio;
		this.seguridadPrivada = seguridadPrivada;
		this.calentadorAgua = calentadorAgua;
		this.eliminado = eliminado;
		this.fechaCreacion = fechaCreacion;
		this.fechaEliminacion = fechaEliminacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPropiedad() {
		return idPropiedad;
	}

	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
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

	public Date getFechaEliminacion() {
		return fechaEliminacion;
	}

	public void setFechaEliminacion(Date fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}

}
