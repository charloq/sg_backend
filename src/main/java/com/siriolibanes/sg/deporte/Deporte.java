package com.siriolibanes.sg.deporte;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.siriolibanes.sg.base.Entidad;
import com.siriolibanes.sg.jugador.Jugador;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "Deporte")
@Table
@Data
@EqualsAndHashCode(callSuper = true)
public class Deporte extends Entidad {

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "deporte")
    private Set<Jugador> jugadores;
}
