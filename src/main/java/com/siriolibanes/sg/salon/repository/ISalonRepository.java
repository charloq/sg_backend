package com.siriolibanes.sg.salon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siriolibanes.sg.salon.model.Salon;

@Repository
public interface ISalonRepository extends JpaRepository<Salon, Long> {

}
