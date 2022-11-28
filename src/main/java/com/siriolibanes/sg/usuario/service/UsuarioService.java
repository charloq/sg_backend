package com.siriolibanes.sg.usuario.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.siriolibanes.sg.rol.model.Rol;
import com.siriolibanes.sg.rol.model.RolEnum;
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
		return usuarioRepository.findByNombreUsuarioContainingIgnoreCase(nombre);
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {
		// Si viene sin roles, se crea como invitado
		if (usuario.getRoles().isEmpty()) {
			Rol rol = new Rol();
			rol.setAutoridad(RolEnum.INVITADO.name());
			rolRepository.save(rol);
			usuario.setRoles(new ArrayList<Rol>());
			usuario.getRoles().add(rol);
		}
		usuario.setNombreUsuario(usuario.getEmail());
		// TODO: Ver si Jugador debería ser un rol y/o tipo de Usuario
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario findOneByEmail(String email) {
		return usuarioRepository.findOneByEmail(email);
	}

	@Override
	public Usuario login(String email, String password) {
		Usuario usuario = usuarioRepository.findOneByEmail(email);
		if (passwordEncoder.matches(password, usuario.getPassword())) {
			return usuario;
		}
		return null;
	}

	@Override
	public Usuario updateUsuario(Usuario usuario, Long id) {
		Usuario unUsuario = findById(id);
		if (unUsuario == null) {
			// TODO: Ver si lanzar exception
			return null;
		}
		// TODO: Acá validar que campos modificar
		unUsuario.setApellido(usuario.getApellido());
		unUsuario.setNombre(usuario.getNombre());
		unUsuario.setEmail(usuario.getEmail());
		unUsuario.setDni(usuario.getDni());
		unUsuario.setActivo(usuario.getActivo());
		unUsuario.setDireccion(usuario.getDireccion());
		unUsuario.setFechaNacimiento(usuario.getFechaNacimiento());
		unUsuario.setTelefono(usuario.getTelefono());

		return usuarioRepository.save(unUsuario);
	}

	@Override
	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).orElse(null);

	}

	@Override
	public void deleteUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	public List<Usuario> findByRoles(List<Rol> roles) {
		return usuarioRepository.findByRolesIn(roles);
	}

	@Override
	public Usuario activarUsuario(Long id) {
		Usuario usuario = findById(id);
		if (usuario == null) {
			throw new IllegalArgumentException("No existe usuario para ese ID");
		}
		usuario.setActivo(!usuario.getActivo());
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario validarUsuario(Long id) {
		Usuario usuario = findById(id);
		if (usuario == null) {
			throw new IllegalArgumentException("No existe usuario para ese ID");
		}
		usuario.getRoles().forEach((Rol rol) -> {
			if (rol.getAutoridad().equals(RolEnum.INVITADO.name())) {
				rol.setAutoridad(RolEnum.SOCIO.name());
			}
		});
		return usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> findByNombre(String nombre) {
		return usuarioRepository.findByNombre(nombre);
	}

}
