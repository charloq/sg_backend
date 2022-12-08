package com.siriolibanes.sg;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.siriolibanes.sg.deportista.service.IDeportistaService;

@SpringBootApplication
@EnableScheduling
public class SgSiriolibanesBackendApplication {

	@Autowired
	private IDeportistaService deportistaService;

	public static void main(String[] args) {
		SpringApplication.run(SgSiriolibanesBackendApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						// .allowedOrigins("http://localhost:5500/**")
						.allowedOrigins("http://127.0.0.1:5500")
						.allowedHeaders("*")
						.allowedMethods("*");
			}
		};
	}

	@Scheduled(fixedDelay = 5000)
	public void revicionActivacion() {
		// System.out.println("Ejecuta el cron a las " + new Date().toString());
		// deportistaService.getDeportistas().forEach(deportista -> {
		// deportista.setActivo(false);
		// deportistaService.saveDeportista(deportista);
		// });
	}
}
