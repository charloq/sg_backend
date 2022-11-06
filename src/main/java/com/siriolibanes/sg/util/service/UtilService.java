package com.siriolibanes.sg.util.service;

import org.springframework.stereotype.Service;

import com.siriolibanes.sg.util.model.Ciudades;

@Service
public class UtilService implements IUtilService {

    @Override
    public String[] getCiudades() {
        return Ciudades.getCiudades();
    }

}
