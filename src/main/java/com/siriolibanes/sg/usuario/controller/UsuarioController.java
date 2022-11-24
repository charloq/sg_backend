package com.siriolibanes.sg.usuario.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siriolibanes.sg.rol.model.Rol;
import com.siriolibanes.sg.usuario.model.Usuario;
import com.siriolibanes.sg.usuario.model.dao.LoginDAO;
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
	public Usuario login(@RequestBody LoginDAO loginDAO) {
		return service.login(loginDAO.getEmail(), loginDAO.getPassword());
	}

	@DeleteMapping(path = "/usuario/{id}")
	public void deleteUsuario(@PathVariable("id") Long id) {
		service.deleteUsuario(id);
	}

	@GetMapping(path = "/roles")
	public List<Usuario> findByRoles(@RequestBody Rol[] roles) {
		return service.findByRoles(Arrays.asList(roles));
	}

	@PostMapping(path = "/activar/{id}")
	public Usuario activarUsuario(@PathVariable("id") Long id) {
		return service.activarUsuario(id);
	}

	@PostMapping(path = "/validar/{id}")
	public Usuario validarUsuario(@PathVariable("id") Long id) {
		return service.validarUsuario(id);
	}
}
