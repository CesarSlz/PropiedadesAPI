package com.terrapp.propiedadesapi.models;

import java.util.Date;

public class Caracteristicas {
	private int id;
	private int idPropiedad;
	private boolean chimenea;
	private boolean accesoDiscapacitados;
	private boolean alberca;
	private boolean amueblado;
	private boolean mascotas;
	private boolean jardin;
	private boolean cocinaIntegral;
	private boolean eliminado;
	private Date fechaCreacion;
	private Date fechaEliminacion;

	public Caracteristicas() {
	}

	public Caracteristicas(int id, int idPropiedad, boolean chimenea, boolean accesoDiscapacitados, boolean alberca,
			boolean amueblado, boolean mascotas, boolean jardin, boolean cocinaIntegral, boolean eliminado,
			Date fechaCreacion, Date fechaEliminacion) {
		this.id = id;
		this.idPropiedad = idPropiedad;
		this.chimenea = chimenea;
		this.accesoDiscapacitados = accesoDiscapacitados;
		this.alberca = alberca;
		this.amueblado = amueblado;
		this.mascotas = mascotas;
		this.jardin = jardin;
		this.cocinaIntegral = cocinaIntegral;
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

	public boolean isChimenea() {
		return chimenea;
	}

	public void setChimenea(boolean chimenea) {
		this.chimenea = chimenea;
	}

	public boolean isAccesoDiscapacitados() {
		return accesoDiscapacitados;
	}

	public void setAccesoDiscapacitados(boolean accesoDiscapacitados) {
		this.accesoDiscapacitados = accesoDiscapacitados;
	}

	public boolean isAlberca() {
		return alberca;
	}

	public void setAlberca(boolean alberca) {
		this.alberca = alberca;
	}

	public boolean isAmueblado() {
		return amueblado;
	}

	public void setAmueblado(boolean amueblado) {
		this.amueblado = amueblado;
	}

	public boolean isMascotas() {
		return mascotas;
	}

	public void setMascotas(boolean mascotas) {
		this.mascotas = mascotas;
	}

	public boolean isJardin() {
		return jardin;
	}

	public void setJardin(boolean jardin) {
		this.jardin = jardin;
	}

	public boolean isCocinaIntegral() {
		return cocinaIntegral;
	}

	public void setCocinaIntegral(boolean cocinaIntegral) {
		this.cocinaIntegral = cocinaIntegral;
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
