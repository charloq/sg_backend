package com.siriolibanes.sg.util.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siriolibanes.sg.util.service.IUtilService;

@RestController
@RequestMapping(path = "api/v1/util")
public class UtilController {

    @Autowired
    private IUtilService utilService;

    @GetMapping(path = "/ciudades")
    public String[] getCiudades() {
        return utilService.getCiudades();
    }

    @GetMapping(path = "/deportes")
    public String[] getDeportes() {
        return utilService.getDeportes();
    }

    @GetMapping(path = "/categorias")
    public String[] getCategorias() {
        return utilService.getCategorias();
    }

    @GetMapping(path = "/sexos")
    public String[] getSexos() {
        return utilService.getSexos();
    }
}
