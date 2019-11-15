package com.terrapp.propiedadesapi.models;

import java.util.Date;

public class Terreno extends Propiedad {
	private int id;
	private int idPropiedad;
	private boolean luz;
	private boolean agua;
	private boolean eliminado;
	private Date fechaCreacion;
	private Date fechaEliminacion;

	public Terreno() {
	}

	public Terreno(int id, int idPropiedad, boolean luz, boolean agua, boolean eliminado, Date fechaCreacion,
			Date fechaEliminacion) {
		this.id = id;
		this.idPropiedad = idPropiedad;
		this.luz = luz;
		this.agua = agua;
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

	public boolean isLuz() {
		return luz;
	}

	public void setLuz(boolean luz) {
		this.luz = luz;
	}

	public boolean isAgua() {
		return agua;
	}

	public void setAgua(boolean agua) {
		this.agua = agua;
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
