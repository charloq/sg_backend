package com.siriolibanes.sg.usuario.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.siriolibanes.sg.rol.Rol;

public class SecurityUser implements UserDetails {

    private Usuario usuario;

    public SecurityUser(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String getUsername() {
        return usuario.getEmail();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Rol> roles = usuario.getRoles();
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(roles.size());
        roles.forEach(rol -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(rol.getAutoridad().name()));
        });
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
