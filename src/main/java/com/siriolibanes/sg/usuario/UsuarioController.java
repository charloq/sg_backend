package com.siriolibanes.sg.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1")
public class UsuarioController {

	private final UsuarioService service;

	@Autowired
	public UsuarioController(UsuarioService service) {
		this.service = service;
	}

	@GetMapping(path = "/usuarios")
	public List<Usuario> getUsuarios() {
		return service.getUsuarios();
	}

	@GetMapping(path = "/usuarios/nombre")
	public Optional<Usuario> getUsuariosByNombre(@RequestBody String nombre) {
		return service.findByNombre(nombre);
	}

	@PostMapping(path = "/usuarios/usuario")
	public Usuario saveUsuario(@RequestBody Usuario usuario) {
		return service.saveUsuario(usuario);
	}
}
