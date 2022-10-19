package com.siriolibanes.sg.rol.service;

import java.util.List;

import com.siriolibanes.sg.rol.Rol;

public interface IRolService {
    public List<Rol> getRoles();

    public List<Rol> findByNombre(String nombre);

    public Rol saveRol(Rol rol);
}
