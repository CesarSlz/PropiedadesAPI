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

import com.terrapp.propiedadesapi.models.Caracteristicas;
import com.terrapp.propiedadesapi.repos.CaracteristicasRepo;

@Controller
@RequestMapping(path = "/caracteristicas")
public class CaracteristicasController {
	@Autowired
	private CaracteristicasRepo caracteristicasRepo;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON }, produces = { MediaType.APPLICATION_JSON })

	public @ResponseBody ResponseEntity<Map<String, Object>> addNewCaracteristicas(
			@RequestBody Caracteristicas caracteristicas) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;

		try {
			caracteristicas.setId(0);
			caracteristicas.setEliminado(false);
			caracteristicas.setFechaCreacion(new Date());
			caracteristicas.setFechaEliminacion(null);
			caracteristicas.setFechaModificacion(null);
			caracteristicasRepo.save(caracteristicas);

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
		response.put("datos", caracteristicas);

		return ResponseEntity.status(status).body(response);
	}

	@GetMapping()
	public @ResponseBody ResponseEntity<Map<String, Object>> getAllCaracteristicas() {

		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;
		List<Caracteristicas> data = new ArrayList<Caracteristicas>();

		try {
			data = Lists.newArrayList(caracteristicasRepo.findAll());
			mensaje = "Exito al consultar características";
			status = Status.OK.getStatusCode();
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al consultar características";
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
	public @ResponseBody ResponseEntity<Map<String, Object>> modifyCaracteristicasById(@PathVariable Integer id,
			@RequestBody Caracteristicas caracteristicas) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;

		try {
			caracteristicas.setId(id);
			caracteristicas.setEliminado(false);
			caracteristicas.setFechaCreacion(caracteristicasRepo.findById(id).get().getFechaCreacion());
			caracteristicas.setFechaEliminacion(null);
			caracteristicas.setFechaModificacion(new Date());

			caracteristicasRepo.save(caracteristicas);

			mensaje = "Exito al actualizar características";
			status = Status.OK.getStatusCode();
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al actualizar características";
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
		response.put("datos", caracteristicas);

		return ResponseEntity.status(status).body(response);
	}

	@DeleteMapping(path = "/{id}")
	public @ResponseBody ResponseEntity<Map<String, Object>> deleteCaracteristicasById(@PathVariable Integer id) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;
		Caracteristicas caracteristicas = null;

		try {

			if (caracteristicasRepo.findById(id).get().isEliminado()) {
				mensaje = "Ya se ha eliminado el registro";
				status = Status.NOT_FOUND.getStatusCode();
			} else {
				caracteristicas = caracteristicasRepo.findById(id).get();
				caracteristicas.setEliminado(true);
				caracteristicas.setFechaEliminacion(new Date());
				caracteristicasRepo.save(caracteristicas);

				mensaje = "Exito al eliminar características";
				status = Status.OK.getStatusCode();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al eliminar características";
			status = Status.BAD_REQUEST.getStatusCode();

		} catch (Exception e) {
			e.printStackTrace();
			mensaje = "Error, contacta al administrador";
			status = Status.INTERNAL_SERVER_ERROR.getStatusCode();
		}
		response = new LinkedHashMap<>();

		response.put("codigo", status);
		response.put("mensaje", mensaje);
		// response.put("datos", caracteristicas);

		return ResponseEntity.status(status).body(response);
	}

}
