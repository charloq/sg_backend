package com.siriolibanes.sg.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.siriolibanes.sg.persona.Persona;

import lombok.Data;

@Data
@Entity(name = "Usuario")
@Table
public class Usuario extends Persona {

	@Id
	@SequenceGenerator(name = "usuario_sequence", sequenceName = "usuario_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence")
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(nullable = false)
	private String nombreUsuario;

	@Column(nullable = false)
	private String password;

	public Usuario(String nombre, String password) {
		this.nombreUsuario = nombre;
		this.password = password;
	}

	/*
	 * @Override
	 * public String toString() {
	 * return "Usuario{" + "id=" + id + ", nombre='" + nombreUsuario + '\'' +
	 * ", password='" + password + '\'' + '}';
	 * }
	 */
}
