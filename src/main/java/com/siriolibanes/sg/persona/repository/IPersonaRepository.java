package com.siriolibanes.sg.persona.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.siriolibanes.sg.persona.model.Persona;

@NoRepositoryBean
public interface IPersonaRepository extends JpaRepository<Persona, Long> {
    List<Persona> findByEmail(String email);
}
