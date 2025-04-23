package com.example.equipo_futbol.Service;

import com.example.equipo_futbol.Model.Jugador;
import com.example.equipo_futbol.Repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JugadorService {
    @Autowired
    private JugadorRepository jugadorRepository;

    public List<Jugador> getAllJugadores(){
        return jugadorRepository.findAll();
    }
    public Optional<Jugador> getJugadorById(Integer id){
        return jugadorRepository.findById(id);
    }
    public Jugador createJugador(Jugador jugador){
        return jugadorRepository.save(jugador);
    }
    public Jugador updateJugador(Integer id, Jugador datos) {
        return jugadorRepository.findById(id)
                .map(j ->{
                j.setNombre(datos.getNombre());
                j.setPosicion(datos.getPosicion());
                j.setDorsal(datos.getDorsal());
                j.setFechaNac(datos.getFechaNac());
                j.setNacionalidad(datos.getNacionalidad());
                j.setEquipo(datos.getEquipo());
                    return jugadorRepository.save(j);
                }).orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
    }

    public void deleteJugador(Integer id) {
        jugadorRepository.deleteById(id);
    }

    public List<Jugador> findByEquipoId(Integer equipoId) {
        return jugadorRepository.findByEquipoId(equipoId);
    }

    public List<Jugador> findJugadoresConMasGoles(Integer minGoles) {
        return jugadorRepository.findJugadoresConMasGoles(minGoles);
    }
}

