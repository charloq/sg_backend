package com.siriolibanes.sg.deporte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siriolibanes.sg.deporte.model.Deporte;
import com.siriolibanes.sg.deporte.service.IDeporteService;

@RestController
@RequestMapping(path = "api/v1/deportes")
public class DeporteController {

    @Autowired
    private IDeporteService deporteService;

    @GetMapping
    public List<Deporte> getDeportes() {
        return deporteService.getDeportes();
    }
}
