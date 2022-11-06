package com.siriolibanes.sg.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping(path = "/{nombre-usuario}")
	public List<Usuario> findByNombreUsuario(@PathVariable("nombre-usuario") String nombre) {
		return service.findByNombreUsuario(nombre);
	}

	@PostMapping(path = "/usuario")
	public Usuario saveUsuario(@RequestBody Usuario usuario) {
		return service.saveUsuario(usuario);
	}

	@PutMapping(path = "/usuario/{id}")
	public Usuario updateUsuario(@RequestBody Usuario usuario, @PathVariable("id") Long id) {
		return service.updateUsuario(usuario, id);
	}

	@PostMapping(path = "/login")
	public Usuario login(@RequestParam("id") String email, @RequestParam("password") String password) {
		return service.login(email, password);
	}

	@DeleteMapping(path = "usuario/{id}")
	public void deleteUsuario(@RequestParam("id") Long id) {
		service.deleteUsuario(id);
	}
}
