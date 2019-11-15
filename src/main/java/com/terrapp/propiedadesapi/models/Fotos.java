package com.terrapp.propiedadesapi.models;

import java.util.Date;

public class Fotos {
	private int id;
	private int idPropiedad;
	private String nombre;
	private Date fechaCreacion;

	public Fotos() {
	}

	public Fotos(int id, int idPropiedad, String nombre, Date fechaCreacion) {
		super();
		this.id = id;
		this.idPropiedad = idPropiedad;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
