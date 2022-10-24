package com.siriolibanes.sg.reserva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siriolibanes.sg.reserva.model.Reserva;
import com.siriolibanes.sg.reserva.service.IReservaService;

@RestController
@RequestMapping(path = "api/v1/reservas")
public class ReservaController {

    @Autowired
    private IReservaService reservaService;

    @GetMapping(path = "/usuario")
    public List<Reserva> getReservasByUsuario() {
        return reservaService.getReservasByUsuario(null);
    }

    @PostMapping(path = "/reserva")
    public Reserva saveReserva(Reserva reserva) {
        return reservaService.saveReserva(reserva);
    }

}
