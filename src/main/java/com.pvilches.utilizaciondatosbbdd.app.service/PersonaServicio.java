package com.pvilches.utilizaciondatosbbdd.app.service;

import com.pvilches.utilizaciondatosbbdd.app.dao.PersonaDao;
import com.pvilches.utilizaciondatosbbdd.app.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServicio {

    @Autowired
    PersonaDao personaDao;
    public List<Persona> listarPersonas(){
        return (List<Persona>) personaDao.findAll();
    }

}
