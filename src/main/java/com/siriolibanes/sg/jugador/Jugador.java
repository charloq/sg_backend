package com.siriolibanes.sg.jugador;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.siriolibanes.sg.deporte.model.Deporte;
import com.siriolibanes.sg.persona.model.Persona;
import com.siriolibanes.sg.usuario.model.Usuario;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = true)
public class Jugador extends Usuario {

    // TODO: Ver si acá la relación debería ser de muchos a muchos
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "deporte_id", nullable = false)
    // private Deporte deporte;
}
