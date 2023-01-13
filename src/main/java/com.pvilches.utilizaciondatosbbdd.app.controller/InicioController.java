package com.pvilches.utilizaciondatosbbdd.app.controller;

import com.pvilches.utilizaciondatosbbdd.app.models.Persona;
import com.pvilches.utilizaciondatosbbdd.app.service.PersonaServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class InicioController {
    @Autowired
    private PersonaServicio personaServicio;

    @GetMapping("/")
    public String inicio(Model model){
        String titulo = "Este es un titulo";
        var personas = personaServicio.listarPersonas();
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("personas", personas);
        model.addAttribute("titulo",titulo);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona, Model model){
        String titulo = "Este es un titulo";
        model.addAttribute("titulo",titulo);
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaServicio.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaServicio.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }

    @GetMapping("/eliminar/{idPersona}")
        public String eliminar(Persona persona){
        personaServicio.eliminar(persona);
        return "redirect:/";
    }

}
