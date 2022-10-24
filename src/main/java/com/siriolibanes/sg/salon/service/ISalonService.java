package com.siriolibanes.sg.salon.service;

import java.util.List;

import com.siriolibanes.sg.salon.model.Salon;

public interface ISalonService {

    public Salon saveSalon(Salon salon);

    public List<Salon> getSalones();
}
