package com.siriolibanes.sg.usuario.model.dao;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginDAO implements Serializable {
    private String email;
    private String password;
}
