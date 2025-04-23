package com.example.equipo_futbol.Service;

import com.example.equipo_futbol.Model.EstadisticasJugador;
import com.example.equipo_futbol.Repository.EstadisticasJugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EstadisticasJugadorService {
    @Autowired
    private EstadisticasJugadorRepository estadisticasJugadorRepository;

    public List<EstadisticasJugador> getAllEstadisticasJugador() {
        return estadisticasJugadorRepository.findAll();
    }

    public Optional<EstadisticasJugador> getEstadisiticasJugadorById(Integer id) {
        return estadisticasJugadorRepository.findById(id);
    }

    public EstadisticasJugador createEstadisticaJugador(EstadisticasJugador estadisticasjugador) {
        return estadisticasJugadorRepository.save(estadisticasjugador);

    }

    public EstadisticasJugador updateEstadisticaJugador(Integer id, EstadisticasJugador datos) {
        return estadisticasJugadorRepository.findById(id)
                .map(e -> {
                    e.setJugador(datos.getJugador());
                    e.setPartido(datos.getPartido());
                    e.setMinutosJugados(datos.getMinutosJugados());
                    e.setGoles(datos.getGoles());
                    e.setAsistencias(datos.getAsistencias());
                    e.setTarjetasAmarillas(datos.getTarjetasAmarillas());
                    e.setTarjetasRojas(datos.getTarjetasRojas());
                    return estadisticasJugadorRepository.save(e);
                }).orElseThrow(() -> new RuntimeException("Estadística del jugador no encontrada"));
    }
    public void deleteEstadisticaJugador(Integer id) {
        estadisticasJugadorRepository.deleteById(id);
    }
}