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

import com.terrapp.propiedadesapi.models.Usuario;
import com.terrapp.propiedadesapi.repos.UsuarioRepo;

@Controller
@RequestMapping(path = "/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioRepo usuarioRepo;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON }, produces = { MediaType.APPLICATION_JSON })

	public @ResponseBody ResponseEntity<Map<String, Object>> addNewDomicilo(@RequestBody Usuario usuario) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;

		try {
			usuario.setId(0);
			usuario.setEliminado(false);
			usuario.setFechaCreacion(new Date());
			usuario.setFechaEliminacion(null);
			usuario.setFechaModificacion(null);
			usuarioRepo.save(usuario);

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
		response.put("datos", usuario);

		return ResponseEntity.status(status).body(response);
	}

	@GetMapping()
	public @ResponseBody ResponseEntity<Map<String, Object>> getAllDomicilios() {

		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;
		List<Usuario> data = new ArrayList<Usuario>();

		try {
			data = Lists.newArrayList(usuarioRepo.findAll());
			mensaje = "Exito al consultar Usuarios";
			status = Status.OK.getStatusCode();
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al consultar Usuarios";
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
			@RequestBody Usuario usuario) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;

		try {
			usuario.setId(id);
			usuario.setEliminado(false);
			usuario.setFechaCreacion(usuarioRepo.findById(id).get().getFechaCreacion());
			usuario.setFechaEliminacion(null);
			usuario.setFechaModificacion(new Date());

			usuarioRepo.save(usuario);

			mensaje = "Exito al Actualizar Usuario";
			status = Status.OK.getStatusCode();
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al Actualizar Usuario";
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
		response.put("datos", usuario);

		return ResponseEntity.status(status).body(response);
	}

	@DeleteMapping(path = "/{id}")
	public @ResponseBody ResponseEntity<Map<String, Object>> deleteDomiciloById(@PathVariable Integer id) {
		Map<String, Object> response = null;
		String mensaje = null;
		int status = 0;
		Usuario usuario = null;

		try {

			if (usuarioRepo.findById(id).get().isEliminado()) {
				mensaje = "Ya se Ha eliminado el registro";
				status = Status.NOT_FOUND.getStatusCode();
			} else {
				usuario = usuarioRepo.findById(id).get();
				usuario.setEliminado(true);
				usuario.setFechaEliminacion(new Date());
				usuarioRepo.save(usuario);

				mensaje = "Exito al Eliminar Usuario";
				status = Status.OK.getStatusCode();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			mensaje = "Error al Eliminar usuario";
			status = Status.BAD_REQUEST.getStatusCode();

		} catch (Exception e) {
			e.printStackTrace();
			mensaje = "Error, Contacta al Administrador";
			status = Status.INTERNAL_SERVER_ERROR.getStatusCode();
		}
		response = new LinkedHashMap<>();

		response.put("codigo", status);
		response.put("mensaje", mensaje);
		// response.put("datos", usuario);

		return ResponseEntity.status(status).body(response);
	}

}
