package com.siriolibanes.sg.cupon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siriolibanes.sg.cupon.service.ICuponService;

@RestController
@RequestMapping(path = "api/v1/cupones")
public class CuponController {

    @Autowired
    private ICuponService cuponService;
}
