package com.siriolibanes.sg.deportista.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siriolibanes.sg.deportista.model.Deportista;
import com.siriolibanes.sg.deportista.repository.IDeportistaRepository;

@Service
public class DeportistaService implements IDeportistaService {

    @Autowired
    private IDeportistaRepository deportistaRepository;

    @Override
    public Deportista saveDeportista(Deportista deportista) {
        return deportistaRepository.save(deportista);
    }

    @Override
    public Deportista updateDeportista(Deportista deportista, Long id) {
        Deportista deportistaToUpdate = this.findById(id);
        if (deportistaToUpdate == null) {
            return null;
        }
        // TODO: Acá validar que campos modificar
        deportistaToUpdate.setApellido(deportista.getApellido());
        deportistaToUpdate.setNombre(deportista.getNombre());
        deportistaToUpdate.setEmail(deportista.getEmail());
        deportistaToUpdate.setDni(deportista.getDni());
        deportistaToUpdate.setDireccion(deportista.getDireccion());
        deportistaToUpdate.setFechaNacimiento(deportista.getFechaNacimiento());
        deportistaToUpdate.setTelefono(deportista.getTelefono());
        deportistaToUpdate.setActivo(deportista.getActivo());
        deportistaToUpdate.setCategoria(deportista.getCategoria());
        deportistaToUpdate.setDeporte(deportista.getDeporte());
        deportistaToUpdate.setSexo(deportista.getSexo());
        return deportistaRepository.save(deportista);
    }

    @Override
    public List<Deportista> getDeportistas() {
        return deportistaRepository.findAll();
    }

    @Override
    public List<Deportista> findByDeporteCategoria(String deporte, String categoria) {
        return deportistaRepository.findByDeporteAndCategoria(deporte, categoria);
    }

    @Override
    public List<Deportista> findByDeporte(String deporte) {
        return deportistaRepository.findByDeporte(deporte);
    }

    @Override
    public Deportista findById(Long id) {
        return deportistaRepository.findById(id).orElse(null);
    }

    @Override
    public Deportista activarDeportista(Long id) {
        Deportista deportista = this.findById(id);
        if (deportista == null) {
            return null;
        }
        deportista.setActivo(!deportista.getActivo());
        return deportistaRepository.save(deportista);
    }

    @Override
    public List<Deportista> findByNombre(String nombre) {
        return deportistaRepository.findByNombre(nombre);
    }

    @Override
    public List<Deportista> findByCategoria(String categoria) {
        return deportistaRepository.findByCategoria(categoria);
    }

}
