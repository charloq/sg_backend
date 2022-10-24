package com.siriolibanes.sg.reserva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siriolibanes.sg.reserva.model.Reserva;
import com.siriolibanes.sg.usuario.model.Usuario;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Long>{
    
    List<Reserva> findByUsuario(Usuario usuario); 
}
