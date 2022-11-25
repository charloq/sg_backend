package com.siriolibanes.sg.reserva.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siriolibanes.sg.reserva.model.Reserva;
import com.siriolibanes.sg.reserva.model.dao.ReservaDAO;
import com.siriolibanes.sg.reserva.service.IReservaService;
import com.siriolibanes.sg.salon.model.Salon;
import com.siriolibanes.sg.usuario.model.Usuario;

@RestController
@RequestMapping(path = "api/v1/reservas")
public class ReservaController {

    @Autowired
    private IReservaService reservaService;

    @GetMapping
    public List<Reserva> getReservas() {
        return reservaService.findAll();
    }

    @PostMapping(path = "/reserva")
    public Reserva saveReserva(@RequestBody ReservaDAO reserva) {
        return reservaService.saveReserva(reserva);
    }

    @GetMapping(path = "/{fecha}")
    public List<Reserva> findByFecha(@PathVariable("fecha") Date fecha) {
        return reservaService.findByFecha(fecha);
    }

    @GetMapping(path = "/salon/{fecha}")
    public List<Reserva> findByFechaAndSalon(@PathVariable("fecha") Date fecha, @RequestBody Salon salon) {
        return reservaService.findByFechaAndSalon(fecha, salon);
    }

    @GetMapping(path = "/salon")
    public List<Reserva> findBySalon(@RequestBody Salon salon) {
        return reservaService.findBySalon(salon);
    }

    @GetMapping(path = "/usuario")
    public List<Reserva> findByUsuario(@RequestBody Usuario usuario) {
        return reservaService.findByUsuario(usuario);
    }

    @GetMapping(path = "/vigentes")
    public List<Reserva> findVigentes() {
        return reservaService.findVigentes();
    }
}
