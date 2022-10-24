package com.siriolibanes.sg.rol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siriolibanes.sg.rol.model.Rol;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Long> {

}
