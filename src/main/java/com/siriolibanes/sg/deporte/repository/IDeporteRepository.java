package com.siriolibanes.sg.deporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siriolibanes.sg.deporte.model.Deporte;

@Repository
public interface IDeporteRepository extends JpaRepository<Deporte, Long> {

}
