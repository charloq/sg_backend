package com.siriolibanes.sg.rol;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.siriolibanes.sg.base.Entidad;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = true)
public class Rol extends Entidad {

    @Column(nullable = false, unique = true)
    @Enumerated(value = EnumType.STRING)
    private RolEnum autoridad;

}
