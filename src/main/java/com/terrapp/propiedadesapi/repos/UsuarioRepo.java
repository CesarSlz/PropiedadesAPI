package com.terrapp.propiedadesapi.repos;

import org.springframework.data.repository.CrudRepository;

import com.terrapp.propiedadesapi.models.Usuario;

public interface UsuarioRepo extends CrudRepository<Usuario, Integer> {

}
