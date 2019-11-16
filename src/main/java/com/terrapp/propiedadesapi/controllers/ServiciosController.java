package com.terrapp.propiedadesapi.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.internal.guava.Lists;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.terrapp.propiedadesapi.models.Servicios;
import com.terrapp.propiedadesapi.repos.ServiciosRepo;

@Controller
@RequestMapping(path = "/servicios")
public class ServiciosController {
	@Autowired
	private ServiciosRepo serviciosRepo;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON }, produces = { MediaType.APPLICATION_JSON })

	public @ResponseBody ResponseEntity<Map<String, Object>> addNewServicios(
			@RequestBody Servicios servicios) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;

		try {
			servicios.setId(0);
			servicios.setEliminado(false);
			servicios.setFechaCreacion(new Date());
			servicios.setFechaEliminacion(null);
			servicios.setFechaModificacion(null);
			serviciosRepo.save(servicios);

			mensaje = "Exito en guardar el registro";
			status = Status.OK.getStatusCode();
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error en guardar el registro";
			status = Status.BAD_REQUEST.getStatusCode();

		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			mensaje = "Error, datos incorrectos";
			status = Status.NOT_ACCEPTABLE.getStatusCode();

		} catch (Exception e) {
			e.printStackTrace();
			mensaje = "Error, contacta al administrador";
			status = Status.INTERNAL_SERVER_ERROR.getStatusCode();
		}
		response = new LinkedHashMap<>();

		response.put("codigo", status);
		response.put("mensaje", mensaje);
		response.put("datos", servicios);

		return ResponseEntity.status(status).body(response);
	}

	@GetMapping()
	public @ResponseBody ResponseEntity<Map<String, Object>> getAllServicios() {

		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;
		List<Servicios> data = new ArrayList<Servicios>();

		try {
			data = Lists.newArrayList(serviciosRepo.findAll());
			mensaje = "Exito al consultar servicios";
			status = Status.OK.getStatusCode();
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al consultar servicios";
			status = Status.BAD_REQUEST.getStatusCode();

		} catch (Exception e) {
			e.printStackTrace();
			mensaje = "Error, contacta al administrador";
			status = Status.INTERNAL_SERVER_ERROR.getStatusCode();
		}
		response = new LinkedHashMap<>();

		response.put("codigo", status);
		response.put("mensaje", mensaje);
		response.put("datos", data);

		return ResponseEntity.status(status).body(response);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON }, produces = { MediaType.APPLICATION_JSON })
	public @ResponseBody ResponseEntity<Map<String, Object>> modifyServiciosById(@PathVariable Integer id,
			@RequestBody Servicios servicios) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;

		try {
			servicios.setId(id);
			servicios.setEliminado(false);
			servicios.setFechaCreacion(serviciosRepo.findById(id).get().getFechaCreacion());
			servicios.setFechaEliminacion(null);
			servicios.setFechaModificacion(new Date());

			serviciosRepo.save(servicios);

			mensaje = "Exito al actualizar servicios";
			status = Status.OK.getStatusCode();
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al actualizar servicios";
			status = Status.BAD_REQUEST.getStatusCode();

		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			mensaje = "Error, datos incorrectos";
			status = Status.NOT_ACCEPTABLE.getStatusCode();

		} catch (Exception e) {
			e.printStackTrace();
			mensaje = "Error, contacta al administrador";
			status = Status.INTERNAL_SERVER_ERROR.getStatusCode();
		}
		response = new LinkedHashMap<>();

		response.put("codigo", status);
		response.put("mensaje", mensaje);
		response.put("datos", servicios);

		return ResponseEntity.status(status).body(response);
	}

	@DeleteMapping(path = "/{id}")
	public @ResponseBody ResponseEntity<Map<String, Object>> deleteServiciosById(@PathVariable Integer id) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;
		Servicios servicios = null;

		try {

			if (serviciosRepo.findById(id).get().isEliminado()) {
				mensaje = "Ya se ha eliminado el registro";
				status = Status.NOT_FOUND.getStatusCode();
			} else {
				servicios = serviciosRepo.findById(id).get();
				servicios.setEliminado(true);
				servicios.setFechaEliminacion(new Date());
				serviciosRepo.save(servicios);

				mensaje = "Exito al eliminar servicios";
				status = Status.OK.getStatusCode();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al eliminar servicios";
			status = Status.BAD_REQUEST.getStatusCode();

		} catch (Exception e) {
			e.printStackTrace();
			mensaje = "Error, contacta al administrador";
			status = Status.INTERNAL_SERVER_ERROR.getStatusCode();
		}
		response = new LinkedHashMap<>();

		response.put("codigo", status);
		response.put("mensaje", mensaje);
		// response.put("datos", servicios);

		return ResponseEntity.status(status).body(response);
	}

}
