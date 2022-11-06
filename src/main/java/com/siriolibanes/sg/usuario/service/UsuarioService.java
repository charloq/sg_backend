package com.siriolibanes.sg.usuario.service;

import java.util.ArrayList;
import java.util.List;

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
		return usuarioRepository.findByNombreUsuario(nombre);
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {
		Rol rol = new Rol();
		rol.setAutoridad(RolEnum.ADMIN.name());
		rolRepository.save(rol);
		// TODO: Ver si Jugador debería ser un rol y/o tipo de Usuario
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		if (usuario.getRoles().isEmpty()) {
			usuario.setRoles(new ArrayList<Rol>());
		}
		usuario.getRoles().add(rol);

		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario findOneByEmail(String email) {
		return usuarioRepository.findOneByEmail(email);
	}

	@Override
	public Usuario login(String email, String password) {
		return usuarioRepository.login(email, password);
	}

	@Override
	public Usuario updateUsuario(Usuario usuario, Long id) {
		Usuario unUsuario = usuarioRepository.getReferenceById(id);
		if (unUsuario == null) {
			// TODO: Ver si lanzar exception
			return null;
		}
		// TODO: Acá validar que campos modificar
		unUsuario.setApellido(usuario.getApellido());
		unUsuario.setNombre(usuario.getNombre());
		unUsuario.setDni(usuario.getDni());
		unUsuario.setActivo(usuario.getActivo());
		unUsuario.setDireccion(usuario.getDireccion());
		unUsuario.setFechaNacimiento(usuario.getFechaNacimiento());
		unUsuario.setTelefono(usuario.getTelefono());

		return unUsuario;
	}

	@Override
	public Usuario findOneById(Long id) {
		return usuarioRepository.getReferenceById(id);
	}

	@Override
	public void deleteUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}

}
