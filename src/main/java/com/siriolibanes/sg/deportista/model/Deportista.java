package com.siriolibanes.sg.deportista.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.siriolibanes.sg.persona.model.Persona;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = true)
public class Deportista extends Persona {

    @Column(nullable = false)
    private String deporte;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private Boolean activo = true;

    @Column(nullable = false)
    private String sexo;
}
