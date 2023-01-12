package com.pvilches.utilizaciondatosbbdd.app.controller;

import com.pvilches.utilizaciondatosbbdd.app.service.PersonaServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
