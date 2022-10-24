package com.siriolibanes.sg.salon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siriolibanes.sg.salon.model.Salon;
import com.siriolibanes.sg.salon.service.ISalonService;

@RestController
@RequestMapping(path = "api/v1/salones")
public class SalonController {

    @Autowired
    private ISalonService salonService;

    @GetMapping
    public List<Salon> getSalones() {
        return salonService.getSalones();
    }

    @PostMapping(path = "/salon")
    public Salon saveSalon(@RequestBody Salon salon) {
        return salonService.saveSalon(salon);
    }
}
