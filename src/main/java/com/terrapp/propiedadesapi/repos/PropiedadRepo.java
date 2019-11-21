package com.terrapp.propiedadesapi.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.terrapp.propiedadesapi.models.Propiedad;

public interface PropiedadRepo extends CrudRepository<Propiedad, Integer> {
	
		public List<Propiedad> getByEstatus(String estatus);
		
}
