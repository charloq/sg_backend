package com.siriolibanes.sg.rol;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    public List<Rol> findByNombre(String nombre);
}
