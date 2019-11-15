package com.terrapp.propiedadesapi.models;

import java.util.Date;

public class Inmobiliaria {
	private int id;
	private int idDomicilio;
	private String nombre;
	private String telefono;
	private boolean eliminado;
	private Date fechaCreacion;
	private Date fechaEliminacion;

	public Inmobiliaria() {
		// TODO Auto-generated constructor stub
	}

	public Inmobiliaria(int id, int idDomicilio, String nombre, String telefono, boolean eliminado, Date fechaCreacion,
			Date fechaEliminacion) {
		this.id = id;
		this.idDomicilio = idDomicilio;
		this.nombre = nombre;
		this.telefono = telefono;
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

	public int getIdDomicilio() {
		return idDomicilio;
	}

	public void setIdDomicilio(int idDomicilio) {
		this.idDomicilio = idDomicilio;
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
