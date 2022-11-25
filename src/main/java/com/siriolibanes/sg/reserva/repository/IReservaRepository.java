package com.siriolibanes.sg.reserva.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.siriolibanes.sg.reserva.model.Reserva;
import com.siriolibanes.sg.salon.model.Salon;
import com.siriolibanes.sg.usuario.model.Usuario;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByUsuario(Usuario usuario);

    List<Reserva> findByFecha(Date fecha);

    List<Reserva> findBySalon(Salon salon);

    List<Reserva> findByFechaAndSalon(Date fecha, Salon salon);

    @Query("select r from Reserva r where r.fecha > getdate()")
    List<Reserva> findVigentes();
}
