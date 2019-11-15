package com.terrapp.propiedadesapi.models;

import java.util.Date;

public class SuperUsuario {

	private int id;
	private String correo;
	private String contrasena;
	private Date fechaCreacion;

	public SuperUsuario() {
	}

	public SuperUsuario(int id, String correo, String contrasena, Date fechaCreacion) {
		this.id = id;
		this.correo = correo;
		this.contrasena = contrasena;
		this.fechaCreacion = fechaCreacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
