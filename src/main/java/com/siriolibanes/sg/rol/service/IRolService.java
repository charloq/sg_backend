package com.siriolibanes.sg.rol.service;

import java.util.List;

import com.siriolibanes.sg.rol.Rol;

public interface IRolService {
    public List<Rol> getRoles();

    public Rol saveRol(Rol rol);
}
