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

import com.terrapp.propiedadesapi.models.AreasCompartidas;
import com.terrapp.propiedadesapi.repos.AreasCompartidasRepo;

@Controller
@RequestMapping(path = "/areasCompartidas")
public class AreasCompartidasController {
	@Autowired
	private AreasCompartidasRepo areasCompartidasRepo;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON }, produces = { MediaType.APPLICATION_JSON })

	public @ResponseBody ResponseEntity<Map<String, Object>> addNewAreasCompartidas(
			@RequestBody AreasCompartidas areasCompartidas) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;

		try {
			areasCompartidas.setId(0);
			areasCompartidas.setEliminado(false);
			areasCompartidas.setFechaCreacion(new Date());
			areasCompartidas.setFechaEliminacion(null);
			areasCompartidas.setFechaModificacion(null);
			areasCompartidasRepo.save(areasCompartidas);

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
		response.put("datos", areasCompartidas);

		return ResponseEntity.status(status).body(response);
	}

	@GetMapping()
	public @ResponseBody ResponseEntity<Map<String, Object>> getAllAreasCompartidas() {

		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;
		List<AreasCompartidas> data = new ArrayList<AreasCompartidas>();

		try {
			data = Lists.newArrayList(areasCompartidasRepo.findAll());
			mensaje = "Exito al consultar áreas compartidas";
			status = Status.OK.getStatusCode();
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al consultar áreas compartidas";
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
	public @ResponseBody ResponseEntity<Map<String, Object>> modifyAreasCompartidasById(@PathVariable Integer id,
			@RequestBody AreasCompartidas areasCompartidas) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;

		try {
			areasCompartidas.setId(id);
			areasCompartidas.setEliminado(false);
			areasCompartidas.setFechaCreacion(areasCompartidasRepo.findById(id).get().getFechaCreacion());
			areasCompartidas.setFechaEliminacion(null);
			areasCompartidas.setFechaModificacion(new Date());

			areasCompartidasRepo.save(areasCompartidas);

			mensaje = "Exito al actualizar áreas compartidas";
			status = Status.OK.getStatusCode();
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al actualizar áreas compartidas";
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
		response.put("datos", areasCompartidas);

		return ResponseEntity.status(status).body(response);
	}

	@DeleteMapping(path = "/{id}")
	public @ResponseBody ResponseEntity<Map<String, Object>> deleteAreasCompartidasById(@PathVariable Integer id) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;
		AreasCompartidas areasCompartidas = null;

		try {

			if (areasCompartidasRepo.findById(id).get().isEliminado()) {
				mensaje = "Ya se ha eliminado el registro";
				status = Status.NOT_FOUND.getStatusCode();
			} else {
				areasCompartidas = areasCompartidasRepo.findById(id).get();
				areasCompartidas.setEliminado(true);
				areasCompartidas.setFechaEliminacion(new Date());
				areasCompartidasRepo.save(areasCompartidas);

				mensaje = "Exito al eliminar áreas compartidas";
				status = Status.OK.getStatusCode();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al eliminar áreas compartidas";
			status = Status.BAD_REQUEST.getStatusCode();

		} catch (Exception e) {
			e.printStackTrace();
			mensaje = "Error, contacta al administrador";
			status = Status.INTERNAL_SERVER_ERROR.getStatusCode();
		}
		response = new LinkedHashMap<>();

		response.put("codigo", status);
		response.put("mensaje", mensaje);
		// response.put("datos", areasCompartidas);

		return ResponseEntity.status(status).body(response);
	}

}
