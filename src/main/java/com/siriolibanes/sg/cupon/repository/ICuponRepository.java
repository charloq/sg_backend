package com.siriolibanes.sg.cupon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siriolibanes.sg.cupon.model.Cupon;

@Repository
public interface ICuponRepository extends JpaRepository<Cupon, Long> {

}
