package com.siriolibanes.sg.deportista.service;

import java.util.List;

import com.siriolibanes.sg.deportista.model.Deportista;

public interface IDeportistaService {

    public Deportista saveDeportista(Deportista deportista);

    public Deportista updateDeportista(Deportista deportista, Long id);

    public List<Deportista> getDeportistas();

    public List<Deportista> findByDeporteCategoria(String deporte, String categoria);

    public List<Deportista> findByDeporte(String deporte);

    public Deportista findById(Long id);

    public Deportista activarDeportista(Long id);

    public List<Deportista> findByNombre(String nombre);

    public List<Deportista> findByCategoria(String categoria);

    public void exportarExcel();
}
