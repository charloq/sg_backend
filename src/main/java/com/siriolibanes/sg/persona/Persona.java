package com.siriolibanes.sg.persona;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@MappedSuperclass
public class Persona {

    @Id
    @SequenceGenerator(name = "persona_sequence", sequenceName = "persona_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

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
