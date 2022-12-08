package com.siriolibanes.sg.deportista.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.siriolibanes.sg.deportista.model.Deportista;

@Repository
public interface IDeportistaRepository extends JpaRepository<Deportista, Long> {
    List<Deportista> findByDeporte(String deporte);

    List<Deportista> findByDeporteAndCategoria(String deporte, String categoria);

    @Query("select d from Deportista d where d.nombre like %:nombre%")
    List<Deportista> findByNombre(@Param("nombre") String nombre);

    List<Deportista> findByCategoria(String categoria);
}
