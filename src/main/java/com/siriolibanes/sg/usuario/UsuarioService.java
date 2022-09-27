package com.siriolibanes.sg.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	private final UsuarioRepository repository;

	@Autowired
	public UsuarioService(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}

	public List<Usuario> getUsuarios() {
		return repository.findAll();
	}

	public Optional<Usuario> findByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	public Usuario saveUsuario(Usuario usuario) {
		return repository.save(usuario);
	}
}
