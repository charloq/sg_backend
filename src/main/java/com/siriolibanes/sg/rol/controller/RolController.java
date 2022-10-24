package com.siriolibanes.sg.rol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siriolibanes.sg.rol.model.Rol;
import com.siriolibanes.sg.rol.service.IRolService;

@Controller
@RequestMapping(path = "api/v1")
public class RolController {

    @Autowired
    private IRolService service;

    @GetMapping(path = "/roles")
    public List<Rol> getRoles() {
        return service.getRoles();
    }

    @PostMapping(path = "/roles/save_rol")
    public Rol saveRol(@RequestBody Rol rol) {
        return service.saveRol(rol);
    }
}
