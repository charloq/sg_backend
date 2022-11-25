package com.siriolibanes.sg.reserva.service;

import java.util.Date;
import java.util.List;

import com.siriolibanes.sg.reserva.model.Reserva;
import com.siriolibanes.sg.reserva.model.dao.ReservaDAO;
import com.siriolibanes.sg.salon.model.Salon;
import com.siriolibanes.sg.usuario.model.Usuario;

public interface IReservaService {

    Reserva saveReserva(Reserva reserva);

    List<Reserva> findByUsuario(Usuario usuario);

    List<Reserva> findByFecha(Date fecha);

    List<Reserva> findBySalon(Salon salon);

    List<Reserva> findByFechaAndSalon(Date fecha, Salon salon);

    List<Reserva> findAll();

    Reserva saveReserva(ReservaDAO reserva);

    List<Reserva> findVigentes();
}
