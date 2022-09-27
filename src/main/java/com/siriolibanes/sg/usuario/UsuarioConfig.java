package com.siriolibanes.sg.usuario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

	@Bean
	CommandLineRunner commandLineRunner(UsuarioRepository repository) {
		return args -> {
			/*
			 * Usuario usuarioPrueba = new Usuario("UsuarioPrueba", "pass"); Usuario
			 * usuarioPrueba2 = new Usuario("UsuarioPrueba2", "pass");
			 * repository.saveAll(List.of(usuarioPrueba, usuarioPrueba2));
			 */
		};
	}
}
