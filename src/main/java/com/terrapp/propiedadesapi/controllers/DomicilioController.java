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

import com.terrapp.propiedadesapi.models.Domicilio;
import com.terrapp.propiedadesapi.repos.DomicilioRepo;

@Controller
@RequestMapping(path = "/domicilios")
public class DomicilioController {
	@Autowired
	private DomicilioRepo domicilioRepo;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON }, produces = { MediaType.APPLICATION_JSON })

	public @ResponseBody ResponseEntity<Map<String, Object>> addNewDomicilo(@RequestBody Domicilio domicilio) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;

		try {
			domicilio.setId(0);
			domicilio.setEliminado(false);
			domicilio.setFechaCreacion(new Date());
			domicilio.setFechaEliminacion(null);
			domicilio.setFechaModificacion(null);
			domicilioRepo.save(domicilio);

			mensaje = "Exito en guardar el registro";
			status = Status.OK.getStatusCode();
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error en guardar el registro";
			status = Status.BAD_REQUEST.getStatusCode();

		} catch (Exception e) {
			e.printStackTrace();
			mensaje = "Error, Contacta al Administrador";
			status = Status.INTERNAL_SERVER_ERROR.getStatusCode();
		}
		response = new LinkedHashMap<>();

		response.put("codigo", status);
		response.put("mensaje", mensaje);
		response.put("datos", domicilio);

		return ResponseEntity.status(status).body(response);
	}

	@GetMapping()
	public @ResponseBody ResponseEntity<Map<String, Object>> getAllDomicilios() {

		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;
		List<Domicilio> data = new ArrayList<Domicilio>();

		try {
			data = Lists.newArrayList(domicilioRepo.findAll());
			mensaje = "Exito al consultar Domicilios";
			status = Status.OK.getStatusCode();
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al consultar domicilios";
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
	public @ResponseBody ResponseEntity<Map<String, Object>> modifyDomiciloById(@PathVariable Integer id,
			@RequestBody Domicilio domicilio) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;

		try {
			domicilio.setId(domicilioRepo.findById(id).get().getId());
			domicilio.setEliminado(false);
			domicilio.setFechaCreacion(domicilioRepo.findById(id).get().getFechaCreacion());
			domicilio.setFechaEliminacion(null);
			domicilio.setFechaModificacion(new Date());

			domicilioRepo.save(domicilio);

			mensaje = "Exito al Actualizar Domicilio";
			status = Status.OK.getStatusCode();
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al Actualizar domicilios";
			status = Status.BAD_REQUEST.getStatusCode();

		} catch (Exception e) {
			e.printStackTrace();
			mensaje = "Error, Contacta al Administrador";
			status = Status.INTERNAL_SERVER_ERROR.getStatusCode();
		}
		response = new LinkedHashMap<>();

		response.put("codigo", status);
		response.put("mensaje", mensaje);
		response.put("datos", domicilio);

		return ResponseEntity.status(status).body(response);
	}

	@DeleteMapping(path = "/{id}")
	public @ResponseBody ResponseEntity<Map<String, Object>> deleteDomiciloById(@PathVariable Integer id) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;
		Domicilio domicilio = null;

		try {

			if (domicilioRepo.findById(id).get().isEliminado()) {
				mensaje = "Ya se Ha eliminado el registro";
				status = Status.NOT_FOUND.getStatusCode();
			} else {
				domicilio = domicilioRepo.findById(id).get();
				domicilio.setEliminado(true);
				domicilio.setFechaEliminacion(new Date());
				domicilioRepo.save(domicilio);

				mensaje = "Exito al Eliminar Domicilio";
				status = Status.OK.getStatusCode();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al Eliminar domicilio";
			status = Status.BAD_REQUEST.getStatusCode();

		} catch (Exception e) {
			e.printStackTrace();
			mensaje = "Error, Contacta al Administrador";
			status = Status.INTERNAL_SERVER_ERROR.getStatusCode();
		}
		response = new LinkedHashMap<>();

		response.put("codigo", status);
		response.put("mensaje", mensaje);
		// response.put("datos", domicilio);

		return ResponseEntity.status(status).body(response);
	}

}
