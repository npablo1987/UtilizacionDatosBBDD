package com.pvilches.utilizaciondatosbbdd.app.service;

import com.pvilches.utilizaciondatosbbdd.app.dao.PersonaDao;
import com.pvilches.utilizaciondatosbbdd.app.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServicio {

    @Autowired
    PersonaDao personaDao;

    @Transactional(readOnly = true)
    public List<Persona> listarPersonas(){
        return (List<Persona>) personaDao.findAll();
    }

    @Transactional
    public void guardar(Persona persona){
        personaDao.save(persona);
    }

    @Transactional
    public void eliminar(Persona persona){
        personaDao.delete(persona);
    }

    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona){
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }



}
