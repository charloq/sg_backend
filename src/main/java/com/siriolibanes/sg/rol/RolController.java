package com.siriolibanes.sg.rol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "api/v1")
public class RolController {

    private final RolService service;

    @Autowired
    public RolController(RolService service) {
        super();
        this.service = service;
    }

    @GetMapping(path = "/roles")
    public List<Rol> getRoles() {
        return service.getRoles();
    }

    @GetMapping(path = "/roles/by_nombre")
    public List<Rol> getRolsByNombre(@RequestBody String nombre) {
        return service.findByNombre(nombre);
    }

    @PostMapping(path = "/roles/save_rol")
    public Rol saveRol(@RequestBody Rol rol) {
        return service.saveRol(rol);
    }
}
