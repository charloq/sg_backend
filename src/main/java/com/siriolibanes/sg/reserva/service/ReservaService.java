package com.siriolibanes.sg.reserva.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siriolibanes.sg.reserva.model.Reserva;
import com.siriolibanes.sg.reserva.repository.IReservaRepository;
import com.siriolibanes.sg.salon.model.Salon;
import com.siriolibanes.sg.usuario.model.Usuario;

@Service
public class ReservaService implements IReservaService {

    @Autowired
    private IReservaRepository reservaRepository;

    @Override
    public List<Reserva> getReservasByUsuario(Usuario usuario) {
        return reservaRepository.findByUsuario(usuario);
    }

    @Override
    public Reserva saveReserva(Reserva reserva) {
        //TODO: Aca va la logica para la reserva
        return reservaRepository.save(reserva);
    }

    @Override
    public List<Reserva> getReservasByRangoFechas(Date desde, Date hasta) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Reserva> getReservasBySalonRangoFechas(Salon salon, Date desde, Date hasta) {
        // TODO Auto-generated method stub
        return null;
    }

}
