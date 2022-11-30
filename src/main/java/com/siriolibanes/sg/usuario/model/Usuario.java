package com.siriolibanes.sg.usuario.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.siriolibanes.sg.persona.model.Persona;
import com.siriolibanes.sg.rol.model.Rol;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data()
@EqualsAndHashCode(callSuper = true)
public class Usuario extends Persona {

	@Column(nullable = false, unique = true)
	private String nombreUsuario;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private Boolean activo = true;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id")
	private List<Rol> roles;

	public Usuario() {
		super();
		this.roles = new ArrayList<Rol>();
		this.activo = true;
	}

}
