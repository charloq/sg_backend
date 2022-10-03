package com.siriolibanes.sg.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.siriolibanes.sg.persona.Persona;
import com.siriolibanes.sg.usuario.estado.Estado;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data()
@EqualsAndHashCode(callSuper = true)
public class Usuario extends Persona {

	@Column(nullable = false)
	private String nombreUsuario;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	@Enumerated(value = EnumType.STRING)
	private Estado estado;

}
