package com.terrapp.propiedadesapi.repos;

import org.springframework.data.repository.CrudRepository;

import com.terrapp.propiedadesapi.models.Propiedad;

public interface PropiedadRepo extends CrudRepository<Propiedad, Integer> {

}
