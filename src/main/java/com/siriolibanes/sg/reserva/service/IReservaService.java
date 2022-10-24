package com.siriolibanes.sg.reserva.service;

import java.util.Date;
import java.util.List;

import com.siriolibanes.sg.reserva.model.Reserva;
import com.siriolibanes.sg.salon.model.Salon;
import com.siriolibanes.sg.usuario.model.Usuario;

public interface IReservaService {
    //TODO:Ver si por defecto las reservas son solo por usuario
    public List<Reserva> getReservasByUsuario(Usuario usuario);

    public Reserva saveReserva(Reserva reserva);

    public List<Reserva> getReservasByRangoFechas(Date desde, Date hasta);
    
    public List<Reserva> getReservasBySalonRangoFechas(Salon salon, Date desde, Date hasta);

    
}
