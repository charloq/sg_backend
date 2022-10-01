package com.siriolibanes.sg.permiso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.siriolibanes.sg.base.Entidad;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = true)
public class Permiso extends Entidad {

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = true)
    private String descripcion;

}
