package com.siriolibanes.sg.permiso;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermisoService {

    private final PermisoRepository repository;

    @Autowired
    public PermisoService(PermisoRepository repository) {
        super();
        this.repository = repository;
    }

    public List<Permiso> getPermisos() {
		return repository.findAll();
	}

	public Optional<Permiso> findByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	public Permiso savePermiso(Permiso permiso) {
		return repository.save(permiso);
	}
}
