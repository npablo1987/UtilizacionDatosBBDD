package com.pvilches.utilizaciondatosbbdd.app.dao;


import com.pvilches.utilizaciondatosbbdd.app.models.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<Persona, Integer> {

}

