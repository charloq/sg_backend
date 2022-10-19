package com.siriolibanes.sg.rol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siriolibanes.sg.rol.Rol;
import com.siriolibanes.sg.rol.repository.IRolRepository;

@Service
public class RolService implements IRolService {

    @Autowired
    private IRolRepository repository;

    public List<Rol> getRoles() {
        return repository.findAll();
    }

    public Rol saveRol(Rol rol) {
        return repository.save(rol);
    }
}
