package com.siriolibanes.sg.usuario.service;

import java.util.List;

import com.siriolibanes.sg.usuario.model.Usuario;

public interface IUsuarioService {

	public List<Usuario> getUsuarios();

	public List<Usuario> findByNombreUsuario(String nombre);

	public Usuario saveUsuario(Usuario usuario);

	public Usuario findOneByEmail(String email);
}
