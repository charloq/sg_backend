package com.siriolibanes.sg.deportista.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siriolibanes.sg.deportista.model.Deportista;

@Repository
public interface IDeportistaRepository extends JpaRepository<Deportista, Long> {
    List<Deportista> findByDeporte(String deporte);

    List<Deportista> findByDeporteAndCategoria(String deporte, String categoria);

}
