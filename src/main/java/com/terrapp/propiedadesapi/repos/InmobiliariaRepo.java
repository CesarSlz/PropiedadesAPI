package com.terrapp.propiedadesapi.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.terrapp.propiedadesapi.models.Inmobiliaria;

public interface InmobiliariaRepo extends CrudRepository<Inmobiliaria, Integer> {

	public List<Inmobiliaria> getByVip (boolean vip);
}
