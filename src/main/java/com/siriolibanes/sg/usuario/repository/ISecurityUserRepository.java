package com.siriolibanes.sg.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siriolibanes.sg.usuario.model.SecurityUser;

public interface ISecurityUserRepository extends JpaRepository<SecurityUser, Long> {
    
}
