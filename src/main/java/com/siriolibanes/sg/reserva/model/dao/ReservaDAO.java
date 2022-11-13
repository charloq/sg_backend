package com.siriolibanes.sg.reserva.model.dao;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ReservaDAO {
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fecha;

    private Long usuarioID;

    private Long salonID;

    private String descripcion;
}
