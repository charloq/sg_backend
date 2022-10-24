package com.siriolibanes.sg.usuario.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.siriolibanes.sg.persona.model.Persona;
import com.siriolibanes.sg.rol.Rol;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data()
@EqualsAndHashCode(callSuper = true)
public class Usuario extends Persona {

	@Column(nullable = false, unique = true)
	private String nombreUsuario;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private Boolean activo;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id")
	private List<Rol> roles;

}
