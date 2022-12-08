package com.siriolibanes.sg.deportista.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siriolibanes.sg.deportista.model.Deportista;
import com.siriolibanes.sg.deportista.service.IDeportistaService;

@RestController
@RequestMapping(path = "api/v1/deportistas")
public class DeportistaController {

    @Autowired
    private IDeportistaService deportistaService;

    @GetMapping
    public List<Deportista> getDeportistas() {
        return deportistaService.getDeportistas();
    }

    @PostMapping(path = "/deportista")
    public Deportista saveDeportista(@RequestBody Deportista deportista) {
        return deportistaService.saveDeportista(deportista);
    }

    @PutMapping(path = "/deportista/{id}")
    public Deportista updateDeportista(@RequestBody Deportista deportista, @PathVariable("id") Long id) {
        return deportistaService.updateDeportista(deportista, id);
    }

    @GetMapping(path = "/deporte/{deporte}")
    public List<Deportista> findByDeporte(@PathVariable("deporte") String deporte) {
        return deportistaService.findByDeporte(deporte);
    }

    @GetMapping(path = "deporte-categoria/{deporte}/{categoria}")
    public List<Deportista> findByDeporteAndCategoria(@PathVariable("deporte") String deporte,
            @PathVariable("categoria") String categoria) {
        return deportistaService.findByDeporteCategoria(deporte, categoria);
    }

    @PutMapping(path = "/deportista/activar/{id}")
    public Deportista activarDeportista(@PathVariable("id") Long id) {
        return deportistaService.activarDeportista(id);
    }

    @GetMapping(path = "/nombre/{nombre}")
    public List<Deportista> findByNombre(@PathVariable("nombre") String nombre) {
        return deportistaService.findByNombre(nombre);
    }

    @GetMapping(path = "/categoria/{categoria}")
    public List<Deportista> findByCategoria(@PathVariable("categoria") String categoria) {
        return deportistaService.findByCategoria(categoria);
    }
}
