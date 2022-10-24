package com.siriolibanes.sg.salon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siriolibanes.sg.salon.model.Salon;
import com.siriolibanes.sg.salon.repository.ISalonRepository;

@Service
public class SalonService implements ISalonService {

    @Autowired
    private ISalonRepository salonRepository;

    @Override
    public List<Salon> getSalones() {
        return salonRepository.findAll();
    }

    @Override
    public Salon saveSalon(Salon salon) {
        return salonRepository.save(salon);
    }

}
