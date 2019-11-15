package com.terrapp.propiedadesapi.models;

import java.util.Date;

public class AreasCompartidas {
	private int id;
	private int idPropiedad;
	private boolean alberca;
	private boolean salonUsosMultiples;
	private boolean estacionamientoVisitas;
	private boolean areasRecreativas;
	private boolean eliminado;
	private Date fechaCreacion;
	private Date fechaEliminacion;

	public AreasCompartidas() {
	}

	public AreasCompartidas(int id, int idPropiedad, boolean alberca, boolean salonUsosMultiples,
			boolean estacionamientoVisitas, boolean areasRecreativas, boolean eliminado, Date fechaCreacion,
			Date fechaEliminacion) {
		super();
		this.id = id;
		this.idPropiedad = idPropiedad;
		this.alberca = alberca;
		this.salonUsosMultiples = salonUsosMultiples;
		this.estacionamientoVisitas = estacionamientoVisitas;
		this.areasRecreativas = areasRecreativas;
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

	public boolean isAlberca() {
		return alberca;
	}

	public void setAlberca(boolean alberca) {
		this.alberca = alberca;
	}

	public boolean isSalonUsosMultiples() {
		return salonUsosMultiples;
	}

	public void setSalonUsosMultiples(boolean salonUsosMultiples) {
		this.salonUsosMultiples = salonUsosMultiples;
	}

	public boolean isEstacionamientoVisitas() {
		return estacionamientoVisitas;
	}

	public void setEstacionamientoVisitas(boolean estacionamientoVisitas) {
		this.estacionamientoVisitas = estacionamientoVisitas;
	}

	public boolean isAreasRecreativas() {
		return areasRecreativas;
	}

	public void setAreasRecreativas(boolean areasRecreativas) {
		this.areasRecreativas = areasRecreativas;
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
