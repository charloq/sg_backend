package com.siriolibanes.sg.rol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siriolibanes.sg.rol.Rol;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Long> {

    public List<Rol> findByNombre(String nombre);
}
