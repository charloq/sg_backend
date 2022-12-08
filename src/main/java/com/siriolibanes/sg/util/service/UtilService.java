package com.siriolibanes.sg.util.service;

import org.springframework.stereotype.Service;

import com.siriolibanes.sg.util.model.Categorias;
import com.siriolibanes.sg.util.model.Ciudades;
import com.siriolibanes.sg.util.model.Deportes;
import com.siriolibanes.sg.util.model.Sexos;

@Service
public class UtilService implements IUtilService {

    @Override
    public String[] getCiudades() {
        return Ciudades.getCiudades();
    }

    @Override
    public String[] getDeportes() {
        return Deportes.getDeportes();
    }

    @Override
    public String[] getCategorias() {
        return Categorias.getCategorias();
    }

    @Override
    public String[] getSexos() {
        return Sexos.getSexos();
    }

}
