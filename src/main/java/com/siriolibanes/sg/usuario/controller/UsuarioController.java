package com.siriolibanes.sg.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siriolibanes.sg.usuario.model.Usuario;
import com.siriolibanes.sg.usuario.service.IUsuarioService;

@RestController
@RequestMapping(path = "api/v1/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioService service;

	@GetMapping
	public List<Usuario> getUsuarios() {
		return service.getUsuarios();
	}

	@GetMapping(path = "/nombre")
	public List<Usuario> findByNombreUsuario(@RequestBody String nombre) {
		return service.findByNombreUsuario(nombre);
	}

	@PostMapping(path = "/usuario")
	public Usuario saveUsuario(@RequestBody Usuario usuario) {
		return service.saveUsuario(usuario);
	}
}
