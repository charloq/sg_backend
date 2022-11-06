package com.siriolibanes.sg.persona.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.siriolibanes.sg.base.model.Entidad;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class Persona extends Entidad {

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = true)
    private String apellido;

    @Column(nullable = true, unique = true)
    private String dni;

    @Column(nullable = true)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fechaNacimiento;

    @Column(nullable = true, unique = true)
    private String email;

    @Column(nullable = true)
    private String telefono;

    @Column(nullable = true)
    private String direccion;

    @Column(nullable = true)
    private String ciudad;
}
