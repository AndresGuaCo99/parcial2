package com.example.equipo_futbol.Service;

import com.example.equipo_futbol.Model.Entrenador;
import com.example.equipo_futbol.Repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PartidoService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    //buscar
    public List<Entrenador> findAll() {
        return entrenadorRepository.findAll();
    }

    //buscar por id
    public Optional<Entrenador> findById(Integer id) {
        return entrenadorRepository.findById(id);
    }

    //Guardar
    public Entrenador save(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

//borrar
    public void deleteById(Integer id) {
        entrenadorRepository.deleteById(id);
    }
}
