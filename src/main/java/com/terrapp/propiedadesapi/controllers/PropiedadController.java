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

import com.terrapp.propiedadesapi.models.Propiedad;
import com.terrapp.propiedadesapi.repos.PropiedadRepo;

@Controller
@RequestMapping(path = "/propiedades")
public class PropiedadController {
	@Autowired
	private PropiedadRepo propiedadRepo;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON }, produces = { MediaType.APPLICATION_JSON })

	public @ResponseBody ResponseEntity<Map<String, Object>> addNewPropiedad(@RequestBody Propiedad propiedad) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;

		try {
			propiedad.setId(0);
			propiedad.setEliminado(false);
			propiedad.setFechaCreacion(new Date());
			propiedad.setFechaEliminacion(null);
			propiedad.setFechaModificacion(null);
			propiedadRepo.save(propiedad);

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
		response.put("datos", propiedad);

		return ResponseEntity.status(status).body(response);
	}

	@GetMapping()
	public @ResponseBody ResponseEntity<Map<String, Object>> getAllPropiedads() {

		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;
		List<Propiedad> data = new ArrayList<Propiedad>();

		try {
			data = Lists.newArrayList(propiedadRepo.findAll());
			mensaje = "Exito al consultar Propiedads";
			status = Status.OK.getStatusCode();
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al consultar propiedads";
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
			@RequestBody Propiedad propiedad) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;

		try {
			propiedad.setId(id);
			propiedad.setEliminado(false);
			propiedad.setFechaCreacion(propiedadRepo.findById(id).get().getFechaCreacion());
			propiedad.setFechaEliminacion(null);
			propiedad.setFechaModificacion(new Date());

			propiedadRepo.save(propiedad);

			mensaje = "Exito al Actualizar Propiedad";
			status = Status.OK.getStatusCode();
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al Actualizar propiedads";
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
		response.put("datos", propiedad);

		return ResponseEntity.status(status).body(response);
	}

	@DeleteMapping(path = "/{id}")
	public @ResponseBody ResponseEntity<Map<String, Object>> deleteDomiciloById(@PathVariable Integer id) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;
		Propiedad propiedad = null;

		try {

			if (propiedadRepo.findById(id).get().isEliminado()) {
				mensaje = "Ya se Ha eliminado el registro";
				status = Status.NOT_FOUND.getStatusCode();
			} else {
				propiedad = propiedadRepo.findById(id).get();
				propiedad.setEliminado(true);
				propiedad.setFechaEliminacion(new Date());
				propiedadRepo.save(propiedad);

				mensaje = "Exito al Eliminar Propiedad";
				status = Status.OK.getStatusCode();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al Eliminar propiedad";
			status = Status.BAD_REQUEST.getStatusCode();

		} catch (Exception e) {
			e.printStackTrace();
			mensaje = "Error, Contacta al Administrador";
			status = Status.INTERNAL_SERVER_ERROR.getStatusCode();
		}
		response = new LinkedHashMap<>();

		response.put("codigo", status);
		response.put("mensaje", mensaje);
		// response.put("datos", propiedad);

		return ResponseEntity.status(status).body(response);
	}

}