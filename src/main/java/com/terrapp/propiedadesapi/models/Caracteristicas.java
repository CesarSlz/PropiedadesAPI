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
public class Caracteristicas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_propiedad", referencedColumnName = "id")
	private Propiedad propiedad;
	
	private boolean chimenea;
	private boolean accesoDiscapacitados;
	private boolean alberca;
	private boolean amueblado;
	private boolean mascotas;
	private boolean jardin;
	private boolean cocinaIntegral;
	private boolean eliminado;
	
	@Column(name = "fecha_creacion")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date fechaEliminacion;

	public Caracteristicas() {
	}

	public Caracteristicas(int id, Propiedad propiedad, boolean chimenea, boolean accesoDiscapacitados, boolean alberca,
			boolean amueblado, boolean mascotas, boolean jardin, boolean cocinaIntegral, boolean eliminado,
			Date fechaCreacion, Date fechaEliminacion) {
		this.propiedad = propiedad;
		this.chimenea = chimenea;
		this.accesoDiscapacitados = accesoDiscapacitados;
		this.alberca = alberca;
		this.amueblado = amueblado;
		this.mascotas = mascotas;
		this.jardin = jardin;
		this.cocinaIntegral = cocinaIntegral;
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
