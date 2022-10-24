package com.siriolibanes.sg.deporte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siriolibanes.sg.deporte.model.Deporte;
import com.siriolibanes.sg.deporte.repository.IDeporteRepository;

@Service
public class DeporteService implements IDeporteService {

    @Autowired
    private IDeporteRepository deporteRepository;

    @Override
    public List<Deporte> getDeportes() {
        return deporteRepository.findAll();
    }
}
