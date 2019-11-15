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

import com.terrapp.propiedadesapi.models.Inmobiliaria;
import com.terrapp.propiedadesapi.repos.InmobiliariaRepo;

@Controller
@RequestMapping(path = "/inmobiliarias")
public class InmobiliariaController {
	@Autowired
	private InmobiliariaRepo inmobiliariaRepo;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON }, produces = { MediaType.APPLICATION_JSON })

	public @ResponseBody ResponseEntity<Map<String, Object>> addNewInmobiliaria(
			@RequestBody Inmobiliaria inmobiliaria) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;

		try {
			inmobiliaria.setId(0);
			inmobiliaria.setEliminado(false);
			inmobiliaria.setFechaCreacion(new Date());
			inmobiliaria.setFechaEliminacion(null);
			inmobiliaria.setFechaModificacion(null);
			inmobiliariaRepo.save(inmobiliaria);

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
			mensaje = "Error, Contacta al Administrador";
			status = Status.INTERNAL_SERVER_ERROR.getStatusCode();
		}
		response = new LinkedHashMap<>();

		response.put("codigo", status);
		response.put("mensaje", mensaje);
		response.put("datos", inmobiliaria);

		return ResponseEntity.status(status).body(response);
	}

	@GetMapping()
	public @ResponseBody ResponseEntity<Map<String, Object>> getAllInmobiliarias() {

		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;
		List<Inmobiliaria> data = new ArrayList<Inmobiliaria>();

		try {
			data = Lists.newArrayList(inmobiliariaRepo.findAll());
			mensaje = "Exito al consultar Inmobiliarias";
			status = Status.OK.getStatusCode();
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al consultar Inmobiliarias";
			status = Status.BAD_REQUEST.getStatusCode();

		} catch (Exception e) {
			e.printStackTrace();
			mensaje = "Error, Contacta al Administrador";
			status = Status.INTERNAL_SERVER_ERROR.getStatusCode();
		}
		response = new LinkedHashMap<>();

		response.put("codigo", status);
		response.put("mensaje", mensaje);
		response.put("datos", data);

		return ResponseEntity.status(status).body(response);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON }, produces = { MediaType.APPLICATION_JSON })
	public @ResponseBody ResponseEntity<Map<String, Object>> modifyInmobiliariaById(@PathVariable Integer id,
			@RequestBody Inmobiliaria inmobiliaria) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;

		try {
			inmobiliaria.setId(id);
			inmobiliaria.setEliminado(false);
			inmobiliaria.setFechaCreacion(inmobiliariaRepo.findById(id).get().getFechaCreacion());
			inmobiliaria.setFechaEliminacion(null);
			inmobiliaria.setFechaModificacion(new Date());

			inmobiliariaRepo.save(inmobiliaria);

			mensaje = "Exito al Actualizar Inmobiliaria";
			status = Status.OK.getStatusCode();
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al Actualizar Inmobiliaria";
			status = Status.BAD_REQUEST.getStatusCode();

		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			mensaje = "Error, datos incorrectos";
			status = Status.NOT_ACCEPTABLE.getStatusCode();

		} catch (Exception e) {
			e.printStackTrace();
			mensaje = "Error, Contacta al Administrador";
			status = Status.INTERNAL_SERVER_ERROR.getStatusCode();
		}
		response = new LinkedHashMap<>();

		response.put("codigo", status);
		response.put("mensaje", mensaje);
		response.put("datos", inmobiliaria);

		return ResponseEntity.status(status).body(response);
	}

	@DeleteMapping(path = "/{id}")
	public @ResponseBody ResponseEntity<Map<String, Object>> deleteInmobiliariaById(@PathVariable Integer id) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;
		Inmobiliaria inmobiliaria = null;

		try {

			if (inmobiliariaRepo.findById(id).get().isEliminado()) {
				mensaje = "Ya se Ha eliminado el registro";
				status = Status.NOT_FOUND.getStatusCode();
			} else {
				inmobiliaria = inmobiliariaRepo.findById(id).get();
				inmobiliaria.setEliminado(true);
				inmobiliaria.setFechaEliminacion(new Date());
				inmobiliariaRepo.save(inmobiliaria);

				mensaje = "Exito al Eliminar Inmobiliaria";
				status = Status.OK.getStatusCode();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al Eliminar Inmobiliaria";
			status = Status.BAD_REQUEST.getStatusCode();

		} catch (Exception e) {
			e.printStackTrace();
			mensaje = "Error, Contacta al Administrador";
			status = Status.INTERNAL_SERVER_ERROR.getStatusCode();
		}
		response = new LinkedHashMap<>();

		response.put("codigo", status);
		response.put("mensaje", mensaje);
		// response.put("datos", inmobiliaria);

		return ResponseEntity.status(status).body(response);
	}

}
