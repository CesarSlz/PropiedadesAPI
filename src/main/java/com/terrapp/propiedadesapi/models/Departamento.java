package com.terrapp.propiedadesapi.models;

import java.util.Date;

public class Departamento extends Propiedad {
	private int id;
	private int idPropiedad;
	private String recamara;
	private String bano;
	private String medioBano;
	private String estacionamiento;
	private String piso;
	private boolean elevador;
	private boolean eliminado;
	private Date fechaCreacion;
	private Date fechaEliminacion;

	public Departamento() {
	}

	public Departamento(int id, int idPropiedad, String recamara, String bano, String medioBano, String estacionamiento,
			String piso, boolean elevador, boolean eliminado, Date fechaCreacion, Date fechaEliminacion) {
		this.id = id;
		this.idPropiedad = idPropiedad;
		this.recamara = recamara;
		this.bano = bano;
		this.medioBano = medioBano;
		this.estacionamiento = estacionamiento;
		this.piso = piso;
		this.elevador = elevador;
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

	public String getRecamara() {
		return recamara;
	}

	public void setRecamara(String recamara) {
		this.recamara = recamara;
	}

	public String getBano() {
		return bano;
	}

	public void setBano(String bano) {
		this.bano = bano;
	}

	public String getMedioBano() {
		return medioBano;
	}

	public void setMedioBano(String medioBano) {
		this.medioBano = medioBano;
	}

	public String getEstacionamiento() {
		return estacionamiento;
	}

	public void setEstacionamiento(String estacionamiento) {
		this.estacionamiento = estacionamiento;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public boolean isElevador() {
		return elevador;
	}

	public void setElevador(boolean elevador) {
		this.elevador = elevador;
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
