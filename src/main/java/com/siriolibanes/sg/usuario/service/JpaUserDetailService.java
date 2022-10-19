package com.siriolibanes.sg.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.siriolibanes.sg.usuario.model.SecurityUser;
import com.siriolibanes.sg.usuario.model.Usuario;
import com.siriolibanes.sg.usuario.repository.IUsuarioRepository;

public class JpaUserDetailService implements UserDetailsService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Usuario usuario = usuarioRepository.findOneByEmail(email);
        if (usuario == null) {
            //TODO: ver si se tiene que hacer algo
        }
        SecurityUser securityUser = new SecurityUser(usuario);
        return securityUser;
    }

}
