package com.siriolibanes.sg.usuario.service;

import java.util.List;

import com.siriolibanes.sg.rol.model.Rol;
import com.siriolibanes.sg.usuario.model.Usuario;

public interface IUsuarioService {

	public List<Usuario> getUsuarios();

	public List<Usuario> findByNombreUsuario(String nombre);

	public Usuario saveUsuario(Usuario usuario);

	public Usuario findOneByEmail(String email);

	public Usuario findOneById(Long id);

	public Usuario login(String email, String password);

	public Usuario updateUsuario(Usuario usuario, Long id);

	public void deleteUsuario(Long id);

	List<Usuario> findByRoles(List<Rol> roles);

	public Usuario validarSocioInvitado(Long id);
}
