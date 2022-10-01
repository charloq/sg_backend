package com.siriolibanes.sg.persona;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.siriolibanes.sg.base.Entidad;

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

    @Column(nullable = true)
    private String dni;

    @Column(nullable = true)
    private Date fechaNacimiento;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String telefono;

    @Column(nullable = true)
    private String direccion;

    @Column(nullable = true)
    private String ciudad;
}
