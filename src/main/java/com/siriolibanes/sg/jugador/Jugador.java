package com.siriolibanes.sg.jugador;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.siriolibanes.sg.deporte.Deporte;
import com.siriolibanes.sg.persona.Persona;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = true)
public class Jugador extends Persona {

    // TODO: Ver si acá la relación debería ser de muchos a muchos
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deporte_id", nullable = false)
    private Deporte deporte;
}
