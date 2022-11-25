package com.siriolibanes.sg.reserva.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siriolibanes.sg.reserva.model.Reserva;
import com.siriolibanes.sg.reserva.model.dao.ReservaDAO;
import com.siriolibanes.sg.reserva.repository.IReservaRepository;
import com.siriolibanes.sg.salon.model.Salon;
import com.siriolibanes.sg.salon.service.ISalonService;
import com.siriolibanes.sg.usuario.model.Usuario;
import com.siriolibanes.sg.usuario.service.IUsuarioService;

@Service
public class ReservaService implements IReservaService {

    @Autowired
    private IReservaRepository reservaRepository;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private ISalonService salonService;

    @Override
    public Reserva saveReserva(Reserva reserva) {

        // Valido reserva no sea del pasado
        Date today = new Date();
        if (reserva.getFecha().compareTo(today) < 0) {
            return null;
        }

        // Valido si existe otra reserva
        List<Reserva> reservas = this.findByFechaAndSalon(reserva.getFecha(), reserva.getSalon());
        if (reservas != null && reservas.size() > 0) {
            return null;
        }

        return reservaRepository.save(reserva);
    }

    @Override
    public List<Reserva> findByFecha(Date fecha) {
        return reservaRepository.findByFecha(fecha);
    }

    @Override
    public List<Reserva> findByFechaAndSalon(Date fecha, Salon salon) {
        return reservaRepository.findByFechaAndSalon(fecha, salon);
    }

    @Override
    public List<Reserva> findBySalon(Salon salon) {
        return reservaRepository.findBySalon(salon);
    }

    @Override
    public List<Reserva> findByUsuario(Usuario usuario) {
        return reservaRepository.findByUsuario(usuario);
    }

    @Override
    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva saveReserva(ReservaDAO reserva) {
        // Valido reserva no sea del pasado
        Date today = new Date();
        if (reserva.getFecha().compareTo(today) < 0) {
            return null;
        }

        Usuario usuario = usuarioService.findById(reserva.getUsuarioID());
        Salon salon = salonService.findById(reserva.getSalonID());

        // Valido existencia de usuario y salon
        if (usuario == null || salon == null) {
            return null;
        }

        // Valido si existe otra reserva
        List<Reserva> reservas = this.findByFechaAndSalon(reserva.getFecha(), salon);
        if (reservas != null && reservas.size() > 0) {
            return null;
        }

        Reserva newReserva = new Reserva();
        newReserva.setUsuario(usuario);
        newReserva.setSalon(salon);
        newReserva.setFecha(reserva.getFecha());
        newReserva.setDescripcion(reserva.getDescripcion());

        return reservaRepository.save(newReserva);
    }

    @Override
    public List<Reserva> findVigentes() {
        return reservaRepository.findVigentes();
    }
}
