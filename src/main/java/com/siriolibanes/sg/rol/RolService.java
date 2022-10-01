package com.siriolibanes.sg.rol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {

    private RolRepository repository;

    @Autowired
    public RolService(RolRepository repository) {
        super();
        this.repository = repository;
    }

    public List<Rol> getRoles() {
        return repository.findAll();
    }

    public List<Rol> findByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    public Rol saveRol(Rol rol) {
        return repository.save(rol);
    }
}
