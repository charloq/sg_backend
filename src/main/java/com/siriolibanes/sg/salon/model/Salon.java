package com.siriolibanes.sg.salon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.siriolibanes.sg.base.model.Entidad;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table
@EqualsAndHashCode(callSuper = true)
public class Salon extends Entidad {

    @Column(nullable = false)
    private String nombre;

}
