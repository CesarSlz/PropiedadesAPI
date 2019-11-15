package com.terrapp.propiedadesapi.models;

import java.util.Date;

public class Venta {
	private int id;
	private int idCliente;
	private int idUsuario;
	private int idPropiedad;
	private String estatus;
	private float monto;
	private boolean eliminado;
	private Date fechaCreacion;
	private Date fechaEliminacion;

	public Venta() {
	}

	public Venta(int id, int idCliente, int idUsuario, int idPropiedad, String estatus, float monto, boolean eliminado,
			Date fechaCreacion, Date fechaEliminacion) {
		this.id = id;
		this.idCliente = idCliente;
		this.idUsuario = idUsuario;
		this.idPropiedad = idPropiedad;
		this.estatus = estatus;
		this.monto = monto;
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

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdPropiedad() {
		return idPropiedad;
	}

	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
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
