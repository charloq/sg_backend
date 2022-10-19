package com.siriolibanes.sg.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.siriolibanes.sg.rol.Rol;
import com.siriolibanes.sg.rol.RolEnum;
import com.siriolibanes.sg.rol.repository.IRolRepository;
import com.siriolibanes.sg.usuario.model.Usuario;
import com.siriolibanes.sg.usuario.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private IRolRepository rolRepository;

	@Override
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public List<Usuario> findByNombreUsuario(String nombre) {
		return usuarioRepository.findByNombreUsuario(nombre);
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {
		Rol rol = new Rol();
		rol.setAutoridad(RolEnum.JUGADOR);
		rolRepository.save(rol);
		// TODO: Ver si Jugador debería ser un rol y/o tipo de Usuario
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		usuario.getRoles().add(rol);

		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario findOneByEmail(String email) {
		return usuarioRepository.findOneByEmail(email);
	}

}
