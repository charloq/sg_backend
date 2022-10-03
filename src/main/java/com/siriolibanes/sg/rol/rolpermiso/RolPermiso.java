package com.siriolibanes.sg.rol.rolpermiso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.siriolibanes.sg.base.Entidad;
import com.siriolibanes.sg.permiso.Permiso;
import com.siriolibanes.sg.rol.Rol;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = true)
public class RolPermiso extends Entidad {

    @Column(nullable = false)
    private Rol rol;

    private Permiso permiso;
}
