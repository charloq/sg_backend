package com.siriolibanes.sg.usuario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.siriolibanes.sg.usuario.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

	List<Usuario> findByNombreUsuario(String nombreUsuario);

	@Query("select u from Usuario u where u.email = :email")
	Usuario findOneByEmail(@Param("email") String email);

	@Query("select u from Usuario u where u.email = :email and u.password = :password")
	Usuario login(@Param("email") String email, @Param("password") String password);

	Usuario getReferenceById(Long id);
}
