package com.siriolibanes.sg.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.siriolibanes.sg.persona.Persona;

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

	/*
	 * @Override
	 * public String toString() {
	 * return "Usuario{" + "id=" + id + ", nombre='" + nombreUsuario + '\'' +
	 * ", password='" + password + '\'' + '}';
	 * }
	 */
}
