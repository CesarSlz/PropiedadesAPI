package com.terrapp.propiedadesapi.models;

import java.util.Date;

public class Propiedad {
	private int id;
	private int idDireccion;
	private int idEmpleado;
	private String descripcion;
	private String mantenimiento;
	private String antiguedad;
	private String estado;
	private String areaTerreno;
	private String areaConstruccion;
	private boolean eliminado;
	private Date fechaCreacion;
	private Date fechaEliminacion;

	public Propiedad() {
	}

	public Propiedad(int id, int idDireccion, int idEmpleado, String descripcion, String mantenimiento,
			String antiguedad, String estado, String areaTerreno, String areaConstruccion, boolean eliminado,
			Date fechaCreacion, Date fechaEliminacion) {
		super();
		this.id = id;
		this.idDireccion = idDireccion;
		this.idEmpleado = idEmpleado;
		this.descripcion = descripcion;
		this.mantenimiento = mantenimiento;
		this.antiguedad = antiguedad;
		this.estado = estado;
		this.areaTerreno = areaTerreno;
		this.areaConstruccion = areaConstruccion;
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

	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMantenimiento() {
		return mantenimiento;
	}

	public void setMantenimiento(String mantenimiento) {
		this.mantenimiento = mantenimiento;
	}

	public String getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAreaTerreno() {
		return areaTerreno;
	}

	public void setAreaTerreno(String areaTerreno) {
		this.areaTerreno = areaTerreno;
	}

	public String getAreaConstruccion() {
		return areaConstruccion;
	}

	public void setAreaConstruccion(String areaConstruccion) {
		this.areaConstruccion = areaConstruccion;
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
