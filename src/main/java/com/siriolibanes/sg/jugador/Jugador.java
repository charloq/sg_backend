package com.siriolibanes.sg.jugador;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.siriolibanes.sg.base.model.Entidad;
import com.siriolibanes.sg.usuario.model.Usuario;

import lombok.Data;
import lombok.EqualsAndHashCode;


// @EqualsAndHashCode(callSuper = true)
public class Jugador  {

    // TODO: Ver si acá la relación debería ser de muchos a muchos
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "deporte_id", nullable = false)
    // private Deporte deporte;

//    @Column
    private String deporte;
}
