package com.siriolibanes.sg.reserva.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.siriolibanes.sg.base.model.Entidad;
import com.siriolibanes.sg.salon.model.Salon;
import com.siriolibanes.sg.usuario.model.Usuario;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = true)
public class Reserva extends Entidad {

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fecha;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuario usuario;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Salon salon;

    @Column(nullable = true)
    private String descripcion;
}
