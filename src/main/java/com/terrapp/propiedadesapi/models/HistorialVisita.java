package com.terrapp.propiedadesapi.models;

import java.util.Date;

public class HistorialVisita {
	private int id;
	private int idPropiedad;
	private int idCliente;
	private int numVisitas;
	private Date fecha;

	public HistorialVisita() {
	}

	public HistorialVisita(int id, int idPropiedad, int idCliente, int numVisitas, Date fecha) {
		this.id = id;
		this.idPropiedad = idPropiedad;
		this.idCliente = idCliente;
		this.numVisitas = numVisitas;
		this.fecha = fecha;
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

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getNumVisitas() {
		return numVisitas;
	}

	public void setNumVisitas(int numVisitas) {
		this.numVisitas = numVisitas;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
