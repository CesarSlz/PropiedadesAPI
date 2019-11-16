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

import com.terrapp.propiedadesapi.models.Renta;
import com.terrapp.propiedadesapi.repos.RentaRepo;

@Controller
@RequestMapping(path = "/rentas")
public class RentaController {
	@Autowired
	private RentaRepo rentaRepo;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON }, produces = { MediaType.APPLICATION_JSON })

	public @ResponseBody ResponseEntity<Map<String, Object>> addNewRenta(@RequestBody Renta renta) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;

		try {
			renta.setId(0);
			renta.setEliminado(false);
			renta.setFechaCreacion(new Date());
			renta.setFechaEliminacion(null);
			renta.setFechaModificacion(null);
			rentaRepo.save(renta);

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
		response.put("datos", renta);

		return ResponseEntity.status(status).body(response);
	}

	@GetMapping()
	public @ResponseBody ResponseEntity<Map<String, Object>> getAllRentas() {

		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;
		List<Renta> data = new ArrayList<Renta>();

		try {
			data = Lists.newArrayList(rentaRepo.findAll());
			mensaje = "Exito al consultar Rentas";
			status = Status.OK.getStatusCode();
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al consultar Rentas";
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
	public @ResponseBody ResponseEntity<Map<String, Object>> modifyRentaById(@PathVariable Integer id,
			@RequestBody Renta renta) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;

		try {
			renta.setId(id);
			renta.setEliminado(false);
			renta.setFechaCreacion(rentaRepo.findById(id).get().getFechaCreacion());
			renta.setFechaEliminacion(null);
			renta.setFechaModificacion(new Date());

			rentaRepo.save(renta);

			mensaje = "Exito al Actualizar Renta";
			status = Status.OK.getStatusCode();
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al Actualizar Renta";
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
		response.put("datos", renta);

		return ResponseEntity.status(status).body(response);
	}

	@DeleteMapping(path = "/{id}")
	public @ResponseBody ResponseEntity<Map<String, Object>> deleteRentaById(@PathVariable Integer id) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;
		Renta renta = null;

		try {

			if (rentaRepo.findById(id).get().isEliminado()) {
				mensaje = "Ya se Ha eliminado el registro";
				status = Status.NOT_FOUND.getStatusCode();
			} else {
				renta = rentaRepo.findById(id).get();
				renta.setEliminado(true);
				renta.setFechaEliminacion(new Date());
				rentaRepo.save(renta);

				mensaje = "Exito al Eliminar Renta";
				status = Status.OK.getStatusCode();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al Eliminar Renta";
			status = Status.BAD_REQUEST.getStatusCode();

		} catch (Exception e) {
			e.printStackTrace();
			mensaje = "Error, Contacta al Administrador";
			status = Status.INTERNAL_SERVER_ERROR.getStatusCode();
		}
		response = new LinkedHashMap<>();

		response.put("codigo", status);
		response.put("mensaje", mensaje);
		// response.put("datos", renta);

		return ResponseEntity.status(status).body(response);
	}

}
