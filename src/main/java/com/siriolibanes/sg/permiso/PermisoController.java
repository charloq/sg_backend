package com.siriolibanes.sg.permiso;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1")
public class PermisoController {
    
	private final PermisoService service;

	@Autowired
	public PermisoController(PermisoService service) {
		this.service = service;
	}

	@GetMapping(path = "/permisos")
	public List<Permiso> getPermisos() {
		return service.getPermisos();
	}

	@GetMapping(path = "/permisos/nombre")
	public Optional<Permiso> getPermisosByNombre(@RequestBody String nombre) {
		return service.findByNombre(nombre);
	}

	@PostMapping(path = "/permisos/permiso")
	public Permiso savePermiso(@RequestBody Permiso permiso) {
		return service.savePermiso(permiso);
	}
}
