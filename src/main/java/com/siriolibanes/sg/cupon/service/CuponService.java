package com.siriolibanes.sg.cupon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siriolibanes.sg.cupon.repository.ICuponRepository;

@Service
public class CuponService implements ICuponService {

    @Autowired
    private ICuponRepository cuponRepository;

}
