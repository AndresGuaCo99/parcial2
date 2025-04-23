package com.example.equipo_futbol.Service;

import com.example.equipo_futbol.Model.Entrenador;
import com.example.equipo_futbol.Repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EntrenadorService {
    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public List<Entrenador> getAllEntrenadores() {
        return entrenadorRepository.findAll();
    }

    public Optional<Entrenador> getEntrenadoresById(Integer id) {
        return entrenadorRepository.findById(id);
    }

    public Entrenador createEntrenador(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public Entrenador updateEntrenador(Integer id, Entrenador datos) {
        return entrenadorRepository.findById(id)
                .map(e -> {
                    e.setEspecialidad(datos.getEspecialidad());
                    e.setNombre(datos.getNombre());
                    e.setEquipo(datos.getEquipo());
                    return entrenadorRepository.save(e);
                }).orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));
    }

    public void deleteEntrenador(Integer id) {
        entrenadorRepository.deleteById(id);
    }
}