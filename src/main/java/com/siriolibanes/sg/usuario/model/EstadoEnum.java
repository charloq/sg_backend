package com.siriolibanes.sg.usuario.model;

public enum EstadoEnum {
    ACTIVO("activo"),
    INACTIVO("activo"),
    BLOQUEADO("activo"),
    BAJA("activo");

    public final String codigo;

    EstadoEnum(String codigo) {
        this.codigo = codigo;
    }
}
